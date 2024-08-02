package com.example.duan1_catmusic.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.fragment.Premium_fm;
import com.example.duan1_catmusic.fragment.Thuvien_fm;
import com.example.duan1_catmusic.fragment.Tim_kiem_fm;
import com.example.duan1_catmusic.fragment.Trangchu_fm;
import com.example.duan1_catmusic.model.Nhac;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class TRANGCHU extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    BottomNavigationView bottomNavigationView;
    private List<Nhac> audioFiles;
    private int currentTrackIndex;
    private ImageView img_choi_nhac, img_next_choi_nhac, img_play_choi_nhac, img_prev_choi_nhac;
    private TextView tv_ten_bai_hat, tv_ten_ca_si;
    private SeekBar seebar_choi_nhac;
    private boolean isPlaying = false;
    private android.media.MediaPlayer mediaPlayer;
    private Handler handler;
    private Runnable updateSeekBarRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gd_trangchu);

        img_choi_nhac = findViewById(R.id.img_choi_nhac);
        img_next_choi_nhac = findViewById(R.id.img_next_choi_nhac);
        img_play_choi_nhac = findViewById(R.id.img_play_choi_nhac);
        img_prev_choi_nhac = findViewById(R.id.img_prev_choi_nhac);
        tv_ten_bai_hat = findViewById(R.id.tv_ten_bai_hat);
        tv_ten_ca_si = findViewById(R.id.tv_ten_ca_si);
        seebar_choi_nhac = findViewById(R.id.seebar_choi_nhac);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        handler = new Handler();

        // Fullscreen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        audioFiles = (ArrayList<Nhac>) intent.getSerializableExtra("playlist");
        currentTrackIndex = intent.getIntExtra("currentTrackIndex", 0);

        // Ẩn hoặc hiện các thành phần choi_nhac tùy thuộc vào dữ liệu
        if (audioFiles != null && !audioFiles.isEmpty()) {
            updateUI(currentTrackIndex);
            showMusicControls(true);
            playTrack();
        } else {
            showMusicControls(false);
        }

        img_choi_nhac.setOnClickListener(v -> {
            Intent newIntent = new Intent(TRANGCHU.this, Screen_listening_music.class);
            newIntent.putExtra("playlist", new ArrayList<>(audioFiles));
            newIntent.putExtra("currentTrackIndex", currentTrackIndex);
            startActivityForResult(newIntent, REQUEST_CODE);
        });

        img_play_choi_nhac.setOnClickListener(v -> {
            if (isPlaying) {
                pauseTrack();
            } else {
                playTrack();
            }
        });

        img_next_choi_nhac.setOnClickListener(v -> nextTrack());
        img_prev_choi_nhac.setOnClickListener(v -> prevTrack());

        seebar_choi_nhac.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && isPlaying) {
                    // Seek to the new position in the track
                    if (mediaPlayer != null) {
                        mediaPlayer.seekTo(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Handle start tracking touch
                if (isPlaying) {
                    pauseTrack();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Handle stop tracking touch
                if (!isPlaying) {
                    playTrack();
                }
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navHome) {
                loadFragment(new Trangchu_fm(), false);
            } else if (itemId == R.id.navTimKiem) {
                loadFragment(new Tim_kiem_fm(), false);
            } else if (itemId == R.id.navThuVien) {
                loadFragment(new Thuvien_fm(), false);
            } else {
                loadFragment(new Premium_fm(), false);
            }
            return true;
        });

        loadFragment(new Trangchu_fm(), true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
        handler.removeCallbacks(updateSeekBarRunnable);
    }

    private void loadFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        if (addToBackStack) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    private void showMusicControls(boolean show) {
        if (show) {
            img_choi_nhac.setVisibility(View.VISIBLE);
            img_next_choi_nhac.setVisibility(View.VISIBLE);
            img_play_choi_nhac.setVisibility(View.VISIBLE);
            img_prev_choi_nhac.setVisibility(View.VISIBLE);
            tv_ten_bai_hat.setVisibility(View.VISIBLE);
            tv_ten_ca_si.setVisibility(View.VISIBLE);
            seebar_choi_nhac.setVisibility(View.VISIBLE);
        } else {
            img_choi_nhac.setVisibility(View.GONE);
            img_next_choi_nhac.setVisibility(View.GONE);
            img_play_choi_nhac.setVisibility(View.GONE);
            img_prev_choi_nhac.setVisibility(View.GONE);
            tv_ten_bai_hat.setVisibility(View.GONE);
            tv_ten_ca_si.setVisibility(View.GONE);
            seebar_choi_nhac.setVisibility(View.GONE);
        }
    }

    private void updateUI(int trackIndex) {
        Nhac track = audioFiles.get(trackIndex);
        tv_ten_bai_hat.setText(track.getTenNhac());
        tv_ten_ca_si.setText(track.getTenCaSi());
        String hinhNhac = track.getHinhNhac();
        int resID = getResources().getIdentifier(hinhNhac, "drawable", getPackageName());
        if (resID != 0) {
            img_choi_nhac.setImageResource(resID);
        } else {
            img_choi_nhac.setImageResource(R.drawable.rosealbum); // Default image
        }
    }

    private void playTrack() {
        // Dừng và giải phóng MediaPlayer hiện tại nếu nó đang phát
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        // Tạo MediaPlayer mới và phát bài hát
        Nhac track = audioFiles.get(currentTrackIndex);
        int residnhac = getResources().getIdentifier(track.getFileNhac(), "raw", getPackageName());
        mediaPlayer = android.media.MediaPlayer.create(this, residnhac);
        mediaPlayer.start();
        isPlaying = true;
        img_play_choi_nhac.setImageResource(R.drawable.ic_pause);

        // Thiết lập listener khi bài hát phát xong
        mediaPlayer.setOnCompletionListener(mp -> nextTrack());

        // Cập nhật SeekBar
        seebar_choi_nhac.setMax(mediaPlayer.getDuration());

        updateSeekBarRunnable = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && isPlaying) {
                    seebar_choi_nhac.setProgress(mediaPlayer.getCurrentPosition());
                    handler.postDelayed(this, 1000);
                }
            }
        };
        handler.post(updateSeekBarRunnable);
    }

    private void pauseTrack() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPlaying = false;
            img_play_choi_nhac.setImageResource(R.drawable.ic_play);
        }
    }

    private void nextTrack() {
        if (audioFiles != null && !audioFiles.isEmpty()) {
            currentTrackIndex = (currentTrackIndex + 1) % audioFiles.size();
            updateUI(currentTrackIndex);
            playTrack();
        }
    }

    private void prevTrack() {
        if (audioFiles != null && !audioFiles.isEmpty()) {
            currentTrackIndex = (currentTrackIndex - 1 + audioFiles.size()) % audioFiles.size();
            updateUI(currentTrackIndex);
            playTrack();
        }
    }
}

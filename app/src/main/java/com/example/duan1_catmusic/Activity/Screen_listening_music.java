package com.example.duan1_catmusic.Activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1_catmusic.R;

public class Screen_listening_music extends AppCompatActivity {

    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private ImageView imgDia;
    private ObjectAnimator animator;
    private TextView tvTimeStart, tvTimeEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_listening_music);

        seekBar = findViewById(R.id.seekBar);
        imgDia = findViewById(R.id.img_dia);
        tvTimeStart = findViewById(R.id.tv_time_start);
        tvTimeEnd = findViewById(R.id.tv_time_end);
        mediaPlayer = MediaPlayer.create(this, R.raw.gone);

        mediaPlayer.setOnPreparedListener(mp -> {
            seekBar.setMax(mediaPlayer.getDuration());
            updateTimeEnd();
            mediaPlayer.start();
            startRotation();
            updateSeekBar();
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar.getProgress() == seekBar.getMax()) {
                    startActivity(new Intent(Screen_listening_music.this, Screen_QuangCao.class));
                    finish();
                }
            }
        });
    }

    private void startRotation() {
        animator = ObjectAnimator.ofFloat(imgDia, "rotation", 0f, 360f);
        animator.setDuration(7000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.RESTART);
        animator.start();
    }

    private void updateSeekBar() {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        updateTimeStart();
        handler.postDelayed(runnable, 1000);
    }

    private void updateTimeStart() {
        int currentPosition = mediaPlayer.getCurrentPosition();
        tvTimeStart.setText(formatTime(currentPosition));
    }

    private void updateTimeEnd() {
        int duration = mediaPlayer.getDuration();
        tvTimeEnd.setText(formatTime(duration));
    }

    private String formatTime(int milliseconds) {
        int minutes = (milliseconds / 1000) / 60;
        int seconds = (milliseconds / 1000) % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                updateSeekBar();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        handler.removeCallbacks(runnable);
        if (animator != null) {
            animator.cancel();
        }
    }
}

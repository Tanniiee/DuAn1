package com.example.duan1_catmusic.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.duan1_catmusic.R;
import java.util.ArrayList;

public class Screen_Next extends AppCompatActivity {

    private ImageView ivHinhCasi1, ivHinhCasi2, ivHinhCasi3, ivHinhCasi4, ivHinhCasi5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_next);

        ivHinhCasi1 = findViewById(R.id.ivHinhCasi1);
        ivHinhCasi2 = findViewById(R.id.ivHinhCasi2);
        ivHinhCasi3 = findViewById(R.id.ivHinhCasi3);
        ivHinhCasi4 = findViewById(R.id.ivHinhCasi4);
        ivHinhCasi5 = findViewById(R.id.ivHinhCasi5);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ArrayList<String> selectedArtistIds = getIntent().getStringArrayListExtra("selectedArtistIds");

        if (selectedArtistIds != null && selectedArtistIds.size() == 5) {
            ivHinhCasi1.setImageResource(getResources().getIdentifier(selectedArtistIds.get(0), "drawable", getPackageName()));
            ivHinhCasi2.setImageResource(getResources().getIdentifier(selectedArtistIds.get(1), "drawable", getPackageName()));
            ivHinhCasi3.setImageResource(getResources().getIdentifier(selectedArtistIds.get(2), "drawable", getPackageName()));
            ivHinhCasi4.setImageResource(getResources().getIdentifier(selectedArtistIds.get(3), "drawable", getPackageName()));
            ivHinhCasi5.setImageResource(getResources().getIdentifier(selectedArtistIds.get(4), "drawable", getPackageName()));
        }
    }
}

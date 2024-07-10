package com.example.duan1_catmusic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class Sreen_Chao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.gd_chao);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView Gif = findViewById(R.id.img_gif);

        int gifResource = R.mipmap.gif_chao;
        Glide.with(this)
                .asGif()
                .load(gifResource)
                .into(Gif);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Tạo Intent để chuyển sang SecondActivity
                Intent intent = new Intent(Sreen_Chao.this, Screen_DangNhap.class);
                startActivity(intent);
                // Kết thúc MainActivity
                finish();
            }
        }, 3000);
    }
}
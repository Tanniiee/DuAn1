package com.example.duan1_catmusic.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.duan1_catmusic.R;

public class Screen_DangNhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gd_dang_nhap);

        TextView btn_dn = findViewById(R.id.btn_dn);
        Button btn_dk = findViewById(R.id.btn_dangky);

        btn_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen_DangNhap.this,Screen_mail.class);
                startActivity(intent);
            }
        });
        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen_DangNhap.this, Screen_NhapTTDangnhap.class);
                startActivity(intent);
            }
        });

    }
}
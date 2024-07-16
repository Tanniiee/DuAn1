package com.example.duan1_catmusic.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.fragment.Premium_fm;
import com.example.duan1_catmusic.fragment.Thuvien_fm;
import com.example.duan1_catmusic.fragment.Tim_kiem_fm;
import com.example.duan1_catmusic.fragment.Trangchu_fm;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TrangchuAdmin extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu_admin);

        bottomNavigationView = findViewById(R.id.bottom_nav_view_admin);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }
}
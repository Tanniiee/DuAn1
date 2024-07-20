package com.example.duan1_catmusic.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_catmusic.Adapter.MusicPlayer;
import com.example.duan1_catmusic.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycleViewTest = findViewById(R.id.recycleViewTest);


        // Lấy đối tượng Button từ layout


        // Đặt sự kiện click cho nút Play

    }
}

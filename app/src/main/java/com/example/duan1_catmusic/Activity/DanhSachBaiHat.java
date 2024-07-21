package com.example.duan1_catmusic.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.duan1_catmusic.Adapter.DSplaylistAdapter;
import com.example.duan1_catmusic.Adapter.MusicAdapter;
import com.example.duan1_catmusic.Adapter.TheLoaiAdapter;
import com.example.duan1_catmusic.DAO.DSplaylistDAO;
import com.example.duan1_catmusic.DAO.TheLoaiDAO;
import com.example.duan1_catmusic.DAO.casiDAO;
import com.example.duan1_catmusic.DAO.nhacDAO;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.Music;
import com.example.duan1_catmusic.model.casi;

import java.util.ArrayList;

public class DanhSachBaiHat extends AppCompatActivity {
    private ArrayList<Music> list;
    private RecyclerView rcv_list_danh_sach_nhac;
    private nhacDAO nhac_DAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gd_danh_sach_bai_hat);

        rcv_list_danh_sach_nhac = findViewById(R.id.rcvlistDanhsachnhac);

        list = nhac_DAO.getnhac();
        nhac_DAO = new nhacDAO(this);


        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        rcv_list_danh_sach_nhac.setLayoutManager(manager);

        MusicAdapter adapter = new MusicAdapter(list, this);
        rcv_list_danh_sach_nhac.setAdapter(adapter);

    }
}
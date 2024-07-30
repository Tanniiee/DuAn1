package com.example.duan1_catmusic.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_catmusic.Adapter.DSplaylistAdapter;
import com.example.duan1_catmusic.Adapter.TheLoaiAdapter;
import com.example.duan1_catmusic.DAO.DSplaylistDAO;
import com.example.duan1_catmusic.DAO.TheLoaiDAO;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.DSplaylist;
import com.example.duan1_catmusic.model.TheLoai;

import java.util.ArrayList;

public class Screen_nhacTheotheloai extends AppCompatActivity {

    private RecyclerView rcvlist1,rcvlist,rcvtheloai;
    private DSplaylistDAO dSplaylistDAO;
    private TheLoaiDAO theLoaiDAO;

    private ArrayList<DSplaylist> list;
    private ArrayList<TheLoai> list2;

    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_screen_nhac_theotheloai);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;




        });

        rcvlist1 = findViewById(R.id.rcvlist1);
        rcvlist = findViewById(R.id.rcvlist);
        rcvtheloai = findViewById(R.id.rcvtheloai);
        back = findViewById(R.id.back);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        list = new ArrayList<>();

        list2 = new ArrayList<>();

        dSplaylistDAO = new DSplaylistDAO(this);
        theLoaiDAO = new TheLoaiDAO(this);

        loadData();
    }

    private void loadData(){
        list = dSplaylistDAO.getDSplaylist();
        list2 = theLoaiDAO.getTheLoai();


        GridLayoutManager manager2 = new GridLayoutManager(this, 2);
        rcvtheloai.setLayoutManager(manager2);
        TheLoaiAdapter adapter2 = new TheLoaiAdapter(this, list2);
        rcvtheloai.setAdapter(adapter2);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        rcvlist1.setLayoutManager(manager);
        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(RecyclerView.HORIZONTAL);
        rcvlist.setLayoutManager(manager1);

        DSplaylistAdapter adapter = new DSplaylistAdapter(this,list);
        rcvlist1.setAdapter(adapter);
        rcvlist.setAdapter(adapter);
    }
}
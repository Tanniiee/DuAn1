package com.example.duan1_catmusic.Activity;

import android.os.Bundle;
import android.view.View;
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
import com.example.duan1_catmusic.Adapter.casiAdapter;
import com.example.duan1_catmusic.DAO.DSplaylistDAO;
import com.example.duan1_catmusic.DAO.casiDAO;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.DSplaylist;
import com.example.duan1_catmusic.model.casi;

import java.util.ArrayList;

public class Screen_nhacTheotheloai extends AppCompatActivity {

    private RecyclerView rcvlist1,rcvlist;
    private DSplaylistDAO dSplaylistDAO;

    private ArrayList<DSplaylist> list;

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
        back = findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        list = new ArrayList<>();

        dSplaylistDAO = new DSplaylistDAO(this);

        loadData();
    }

    private void loadData(){
        list = dSplaylistDAO.getDSplaylist();

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
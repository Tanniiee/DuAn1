package com.example.duan1_catmusic.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1_catmusic.Activity.Screen_ListSong_YeuThich;
import com.example.duan1_catmusic.Activity.Screen_ThuVien_NgheSi;
import com.example.duan1_catmusic.Activity.TRANGCHU;
import com.example.duan1_catmusic.Adapter.thuvienAdapter;
import com.example.duan1_catmusic.DAO.casiDAO;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.Casi;

import java.util.ArrayList;

public class Thuvien_fm extends Fragment {

    private RecyclerView rvlistCasi;
    private com.example.duan1_catmusic.DAO.casiDAO casiDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thuvien, container, false);

        TextView tvListyeuThich = view.findViewById(R.id.tvListYeuThich);

        casiDAO  =new casiDAO(getContext());
        TextView tvListNgheSi = view.findViewById(R.id.tvListNgheSi);

        tvListNgheSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Screen_ThuVien_NgheSi.class);
                startActivity(intent);
            }
        });
//        ArrayList<Casi> list = casiDAO.getcasi();
//        LinearLayoutManager manager = new LinearLayoutManager(getContext());
//        Casi casi;
//                manager.setOrientation(RecyclerView.VERTICAL);
//        rvlistCasi.setLayoutManager(manager);
//
//        thuvienAdapter adapter = new thuvienAdapter(getContext(), list);
//        rvlistCasi.setAdapter(adapter);

        tvListyeuThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Screen_ListSong_YeuThich.class);
                startActivity(intent);

            }
        });
        return view;

    }
}
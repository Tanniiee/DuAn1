package com.example.duan1_catmusic.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.duan1_catmusic.Adapter.TheLoaiAdapter;
import com.example.duan1_catmusic.DAO.TheLoaiDAO;
import com.example.duan1_catmusic.DAO.casiDAO;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.TheLoai;
import com.example.duan1_catmusic.model.casi;

import java.util.ArrayList;

public class Tim_kiem_fm extends Fragment {

    private RecyclerView rcvtheloai;
    private TheLoaiDAO theLoaiDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tim_kiem, container, false);

        rcvtheloai = view.findViewById(R.id.rcvtheloai);
        SearchView edt_timkiem = view.findViewById(R.id.edt_timkiem);
        theLoaiDAO  =new TheLoaiDAO(getContext());

        ArrayList<TheLoai> list = theLoaiDAO.getTheLoai();

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        rcvtheloai.setLayoutManager(manager);
        TheLoaiAdapter adapter = new TheLoaiAdapter(getContext(), list);
        rcvtheloai.setAdapter(adapter);


        edt_timkiem.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);



                return true;
            }
        });



        return view;
    }
}
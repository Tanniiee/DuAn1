package com.example.duan1_catmusic.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.duan1_catmusic.Adapter.casiAdapter;
import com.example.duan1_catmusic.DAO.casiDAO;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.casi;

import java.util.ArrayList;

public class Trangchu_fm extends Fragment {


    private RecyclerView rcvnghesi;
    private casiDAO casiDAO;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trangchu, container, false);

        rcvnghesi = view.findViewById(R.id.rcvnghesi);


        casiDAO  =new casiDAO(getContext());

        ArrayList<casi> list = casiDAO.getcasi();

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        rcvnghesi.setLayoutManager(manager);

        casiAdapter adapter = new casiAdapter(list,getContext());
        rcvnghesi.setAdapter(adapter);



        return view;
    }
}
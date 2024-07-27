package com.example.duan1_catmusic.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1_catmusic.Adapter.thuvienAdapter;
import com.example.duan1_catmusic.DAO.casiDAO;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.casi;

import java.util.ArrayList;


public class NghesiAdmin_fm extends Fragment {


    private RecyclerView rvlistCasiadmin;
    private com.example.duan1_catmusic.DAO.casiDAO casiDAO;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nghesi_admin_fm, container, false);

        rvlistCasiadmin = view.findViewById(R.id.rvListCaSiadmin);
        casiDAO  =new casiDAO(getContext());

        ArrayList<casi> list = casiDAO.getcasi();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        rvlistCasiadmin.setLayoutManager(manager);

        thuvienAdapter adapter = new thuvienAdapter(getContext(), list);
        rvlistCasiadmin.setAdapter(adapter);

        return view;
    }
}
package com.example.duan1_catmusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_catmusic.Adapter.MusicAdapter;
import com.example.duan1_catmusic.Adapter.thuvienAdapter;
import com.example.duan1_catmusic.DAO.nhacDAO;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.Nhac;

import java.util.ArrayList;
import java.util.List;

public class TrangchuAdmin_fm extends Fragment {
    private RecyclerView rcvlistDanhsachnhacadmin;
    private nhacDAO nhacDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout cho fragment này
        View view = inflater.inflate(R.layout.fragment_trangchu_admin_fm, container, false);

        rcvlistDanhsachnhacadmin = view.findViewById(R.id.rcvlistDanhsachnhacadmin);

        //data
        nhacDAO = new nhacDAO(getContext());
        List<Nhac> list = nhacDAO.getSongArtistList();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvlistDanhsachnhacadmin.setLayoutManager(linearLayoutManager);
        MusicAdapter musicAdapter = new MusicAdapter(list,getContext());
        rcvlistDanhsachnhacadmin.setAdapter(musicAdapter);

        // Tìm nút btnaddnewmusic theo ID
        Button btnAddNewMusic = view.findViewById(R.id.btnaddnewmusic);



        // Đặt sự kiện click cho nút
        btnAddNewMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị dialog khi nút được nhấn
                showAddMusicDialog();
            }
        });

        return view;
    }

    private void showAddMusicDialog() {
        // Tạo dialog và inflate layout
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_themnhac, null);
        builder.setView(dialogView);

        // Thiết lập các nút bấm trong dialog nếu cần thiết
        builder.setPositiveButton("Thêm", (dialog, id) -> {
            // Thực hiện hành động khi nhấn nút Thêm
            Toast.makeText(getActivity(), "Thêm bài hát", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Hủy", (dialog, id) -> dialog.dismiss());

        // Hiển thị dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}

package com.example.duan1_catmusic.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_catmusic.Adapter.MusicAdapter;
import com.example.duan1_catmusic.DAO.nhacDAO;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.Nhac;

import java.util.List;

public class TrangchuAdmin_fm extends Fragment {
    private RecyclerView rcvlistDanhsachnhacadmin;
    private nhacDAO nhacDAO;
    private Uri imageUri;
    private static final int PICK_IMAGE_REQUEST = 1; // Mã yêu cầu cho việc chọn hình ảnh
    private ImageView imgHinhNhac; // Thêm biến instance cho ImageView
    private TextView tvFileNhac;
    private MusicAdapter adapter; // Khai báo MusicAdapter

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout cho fragment này
        View view = inflater.inflate(R.layout.fragment_trangchu_admin_fm, container, false);

        rcvlistDanhsachnhacadmin = view.findViewById(R.id.rcvlistDanhsachnhacadmin);
        imgHinhNhac = view.findViewById(R.id.imghinhnhac); // Khởi tạo ImageView

        //data
        nhacDAO = new nhacDAO(getContext());
        List<Nhac> list = nhacDAO.getSongArtistList();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvlistDanhsachnhacadmin.setLayoutManager(linearLayoutManager);
        adapter = new MusicAdapter(getContext(), list); // Khởi tạo MusicAdapter
        rcvlistDanhsachnhacadmin.setAdapter(adapter);

        // Tìm nút btnaddnewmusic theo ID
        ImageButton btnAddNewMusic = view.findViewById(R.id.btnaddnewmusic);

        // Đặt sự kiện click cho nút
        btnAddNewMusic.setOnClickListener(v -> showDialogThemNhac());

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            if (requestCode == PICK_IMAGE_REQUEST) {
                imageUri = uri;
                imgHinhNhac.setImageURI(uri); // Hiển thị hình ảnh đã chọn
            }
        }
    }

    private void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    private void showDialogThemNhac() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_themnhac, null);
        builder.setView(dialogView);

        imgHinhNhac = dialogView.findViewById(R.id.imghinhnhac);
        EditText edtMaNhac = dialogView.findViewById(R.id.edtmanhac);
        EditText edtTenNhac = dialogView.findViewById(R.id.edttennhac);
        EditText edtMaLoai = dialogView.findViewById(R.id.edtmaloai);
        EditText edtMaTacGia = dialogView.findViewById(R.id.edtmatacgia);
        EditText edtMaCaSi = dialogView.findViewById(R.id.edtmacasi);
        EditText edtMaLoi = dialogView.findViewById(R.id.edtmaloi);
        ImageButton btnFileNhac = dialogView.findViewById(R.id.btnfilenhac);
        tvFileNhac = dialogView.findViewById(R.id.tvfilenhac);

        imgHinhNhac.setOnClickListener(v -> openImageChooser());

        builder.setPositiveButton("Add", null);
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();

        Button btnAdd = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        btnAdd.setOnClickListener(v -> {

            String maNhac = edtMaNhac.getText().toString().trim();
            String tenNhac = edtTenNhac.getText().toString().trim();
            String maLoai = edtMaLoai.getText().toString().trim();
            String maTacGia = edtMaTacGia.getText().toString().trim();
            String maCaSi = edtMaCaSi.getText().toString().trim();
            String maLoi = edtMaLoi.getText().toString().trim();

            if (imageUri == null) {
                Toast.makeText(getContext(), "Vui lòng chọn hình ảnh", Toast.LENGTH_SHORT).show();
                return;
            }

            Nhac nhac = new Nhac(maNhac, imageUri.toString(), tenNhac, maLoai, maTacGia, maCaSi, maLoi, "", "");
            long result = nhacDAO.insertNhac(nhac); // Sửa tên phương thức

            if (result != -1) {
                adapter.updateData(nhacDAO.getSongArtistList()); // Cập nhật dữ liệu cho adapter
                Toast.makeText(getContext(), "Thêm nhạc thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Thêm nhạc thất bại", Toast.LENGTH_SHORT).show();
            }

            dialog.dismiss();
        });
    }
}

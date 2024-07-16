package com.example.duan1_catmusic.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1_catmusic.DAO.NguoiDungDAO;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.fragment.Trangchu_fm;
import com.google.android.material.textfield.TextInputEditText;

public class Screen_NhapTTDangnhap extends AppCompatActivity {

    private NguoiDungDAO nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_nhap_ttdangnhap);

        TextInputEditText edt_nhap_mai_dn = findViewById(R.id.edt_nhap_mai_dn);
        TextInputEditText edt_nhap_mk_dn = findViewById(R.id.edt_nhap_mk_dn);
        Button btn_tieptt = findViewById(R.id.btn_tieptt);

        nguoiDungDAO = new NguoiDungDAO(this);

        btn_tieptt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namemail = edt_nhap_mai_dn.getText().toString();
                String MatKhau = edt_nhap_mk_dn.getText().toString();

                boolean check = nguoiDungDAO.KiemTraDangNhap(namemail, MatKhau);
                if (check) {
                    startActivity(new Intent(Screen_NhapTTDangnhap.this, Trangchu_fm.class));
                } else {
                    Toast.makeText(Screen_NhapTTDangnhap.this, "Nhập user name, email hoặc mật khẩu sai ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

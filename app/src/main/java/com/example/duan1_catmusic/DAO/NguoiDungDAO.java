package com.example.duan1_catmusic.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_catmusic.database.Dbhelper;

public class NguoiDungDAO {
    private Dbhelper dbhelper;

    public NguoiDungDAO(Context context) {
        dbhelper = new Dbhelper(context);
    }

    // kiểm tra thông tin đăng nhập
    public boolean KiemTraDangNhap(String TenUserOrGmail, String MatKhau) {
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM User WHERE (TenUser = ? OR Gmail = ?) AND MatKhau = ?",
                new String[]{TenUserOrGmail, TenUserOrGmail, MatKhau}
        );
        boolean result = cursor.getCount() > 0;
        cursor.close(); // Đảm bảo đóng cursor để tránh rò rỉ bộ nhớ
        return result;
    }
}

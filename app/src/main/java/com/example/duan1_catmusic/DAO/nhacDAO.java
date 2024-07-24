package com.example.duan1_catmusic.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_catmusic.database.Dbhelper;
import com.example.duan1_catmusic.model.DSplaylist;
import com.example.duan1_catmusic.model.Nhac;

import java.util.ArrayList;
import java.util.List;

public class nhacDAO {
    private Dbhelper dbHelper;

    public nhacDAO(Context context){
        dbHelper = new Dbhelper(context);
    }


    public List<Nhac> getSongArtistList() {
        List<Nhac> songArtistList = new ArrayList<>();
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();
        String query = "SELECT Nhac.MaNhac, Nhac.HinhNhac, Nhac.TenNhac, Nhac.MaLoai, Nhac.MaTacGia, Nhac.MaCaSi, Nhac.MaLoi, Nhac.FileNhac, " +
                "CaSi.TenCaSi " +
                "FROM Nhac JOIN CaSi ON Nhac.MaCaSi = CaSi.MaCaSi";

        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String maNhac = cursor.getString(0);
                String hinhNhac = cursor.getString(1);
                String tenNhac = cursor.getString(2);
                String maLoai = cursor.getString(3);
                String maTacGia = cursor.getString(4);
                String maCaSi = cursor.getString(5);
                String maLoi = cursor.getString(6);
                String fileNhac = cursor.getString(7);
                String tenCaSi = cursor.getString(8);
                songArtistList.add(new Nhac(maNhac, hinhNhac, tenNhac, maLoai, maTacGia, maCaSi, maLoi, fileNhac,tenCaSi));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return songArtistList;
    }
    public List<Nhac> Allsong() {
        List<Nhac> allsong = new ArrayList<>();
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();
        String query = "SELECT * FROM Nhac";

        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String maNhac = cursor.getString(0);
                String hinhNhac = cursor.getString(1);
                String tenNhac = cursor.getString(2);
                String maLoai = cursor.getString(3);
                String maTacGia = cursor.getString(4);
                String maCaSi = cursor.getString(5);
                String maLoi = cursor.getString(6);
                String fileNhac = cursor.getString(7);
                String tenCaSi = cursor.getString(8);
                allsong.add(new Nhac(maNhac, hinhNhac, tenNhac, maLoai, maTacGia, maCaSi, maLoi, fileNhac,tenCaSi));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return allsong;
    }
}

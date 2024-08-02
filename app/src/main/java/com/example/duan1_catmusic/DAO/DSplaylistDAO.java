package com.example.duan1_catmusic.DAO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1_catmusic.database.Dbhelper;
import com.example.duan1_catmusic.model.DSplaylist;
import com.example.duan1_catmusic.model.Nhac;

import java.util.ArrayList;
import java.util.List;

public class DSplaylistDAO {

    private Dbhelper dbHelper;
    public DSplaylistDAO(Context context){
        dbHelper = new Dbhelper(context);
    }


//    public ArrayList<DSplaylist> getDSplaylist(){
//        ArrayList<DSplaylist> list = new ArrayList<>();
//        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM DanhSachPlaylist", null);
//        if (cursor.getCount() > 0){
//            cursor.moveToFirst();
//            do{
//                list.add(new DSplaylist(cursor.getString(0),
//                        cursor.getString(1),
//                        cursor.getString(2),
//                        cursor.getString(3),
//                        cursor.getString(4)));
//            }while (cursor.moveToNext());
//        }
//
//        return list;
//    }

    public List<DSplaylist> getTenloai(){
        List<DSplaylist> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT DISTINCT T.MaLoai,T.TenLoai, N.TenNhac , DSP.HINH\n" +
                "FROM TheLoai T\n" +
                "JOIN Nhac N ON T.MaLoai = N.MaLoai\n" +
                "JOIN DanhSachPlaylist DSP ON N.MaNhac = DSP.MaNhac;", null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                String maLoai = cursor.getString(0);
                String tenLoai = cursor.getString(1);
                String tenNhac = cursor.getString(2);
                String hinh = cursor.getString(3);

                DSplaylist dsplaylist = new DSplaylist("",maLoai,tenLoai,tenNhac,"","",hinh);
                list.add(dsplaylist);
            }while (cursor.moveToNext());
        }cursor.close();

        return list;
}

    public List<DSplaylist> getss(String artistName) {
        List<DSplaylist> allSongs = getTenloai(); // Giả sử đây là phương thức trả về danh sách tất cả các bài hát
        List<DSplaylist> songsByArtist = new ArrayList<>();
        for (DSplaylist song : allSongs) {
            if (song.getTenLoai().equals(artistName)) {
                songsByArtist.add(song);
            }
        }
        return songsByArtist;
    }


}

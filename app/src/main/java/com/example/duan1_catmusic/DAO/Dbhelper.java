package com.example.duan1_catmusic.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelper extends SQLiteOpenHelper {

    public Dbhelper(Context context){
        super(context,"music",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //User
        String QuanlyUser = "CREATE TABLE User(MaUser TEXT PRIMARY KEY, TenUser TEXT, Gmail TEXT, GioiTinh TEXT, NamSinh TEXT, DiaChi TEXT)";
        sqLiteDatabase.execSQL(QuanlyUser);

        //DanhSachPlayList
        String QuanlyDanhSachPlaylist = "CREATE TABLE DanhSachPlaylist(MaDanhSachPlayList TEXT PRIMARY KEY," +
                "FOREIGN KEY(MaNhac) REFERENCES QuanLyNhac(MaNhac))";
        sqLiteDatabase.execSQL(QuanlyDanhSachPlaylist);


        //PlayList
        String QuanLyPlayList = "CREATE TABLE PlayList(MaPlayList TEXT PRIMARY KEY," +
                "FOREIGN KEY(MaUser) REFERENCES QuanlyUser(MaUser))";
        sqLiteDatabase.execSQL(QuanLyPlayList);


        //Nhac
        String QuanLyNhac = "CREATE TABLE Nhac(MaNhac TEXT PRIMARY KEY, TenNhac TEXT," +
                "FOREIGN KEY(MaLoai) REFERENCES QuanLyTheLoai(MaLoai)," +
                "FOREIGN KEY(MaTacGia) REFERENCES QuanLyTacGia(MaTacGia)," +
                "FOREIGN KEY(MaCaSi) REFERENCES QuanLyCaSi(MaCaSi)," +
                "FOREIGN KEY(MaLoi) REFERENCES QuanLyLoiNhac(MaLoi) )";
        sqLiteDatabase.execSQL(QuanLyNhac);


        //TheLoai
        String QuanLyTheLoai = "CREATE TABLE TheLoai(MaLoai TEXT PRIMARY KEY, TenLoai TEXT, MauTheLoai TEXT)";
        sqLiteDatabase.execSQL(QuanLyTheLoai);


        //TacGia
        String QuanLyTacGia = "CREATE TABLE TacGia(MaTacGia TEXT PRIMARY KEY, TenTacGia TEXT,NamSinh TEXT, QueQuan TEXT)";
        sqLiteDatabase.execSQL(QuanLyTacGia);


        //CaSi
        String QuanLyCaSi = "CREATE TABLE CaSi(MaCaSi TEXT PRIMARY KEY, TenCaSi TEXT, QueQuan TEXT, NamSinh TEXT, HinhCaSi TEXT)";
        sqLiteDatabase.execSQL(QuanLyCaSi);


        //LoiNhac
        String QuanLyLoiNhac = "CREATE TABLE LoiNhac(MaLoi TEXT PRIMARY KEY, TenLoi TEXT)";
        sqLiteDatabase.execSQL(QuanLyLoiNhac);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        if (i != i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS User");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DanhSachPlaylist");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Playlist");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Nhac");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TheLoai");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TacGia");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CaSi");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LoiNhac");
            onCreate(sqLiteDatabase);
        }
    }
}

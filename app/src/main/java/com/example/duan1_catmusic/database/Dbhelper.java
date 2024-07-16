package com.example.duan1_catmusic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelper extends SQLiteOpenHelper {

    public Dbhelper(Context context){
        super(context,"music",null,3);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // TheLoai
        String QuanLyTheLoai = "CREATE TABLE TheLoai(MaLoai TEXT PRIMARY KEY, TenLoai TEXT, MauTheLoai TEXT)";
        sqLiteDatabase.execSQL(QuanLyTheLoai);

        // TacGia
        String QuanLyTacGia = "CREATE TABLE TacGia(MaTacGia TEXT PRIMARY KEY, TenTacGia TEXT, NamSinh TEXT, QueQuan TEXT)";
        sqLiteDatabase.execSQL(QuanLyTacGia);

        // CaSi
        String QuanLyCaSi = "CREATE TABLE CaSi(MaCaSi TEXT PRIMARY KEY, TenCaSi TEXT, QueQuan TEXT, NamSinh TEXT, HinhCaSi TEXT)";
        sqLiteDatabase.execSQL(QuanLyCaSi);

        // LoiNhac
        String QuanLyLoiNhac = "CREATE TABLE LoiNhac(MaLoi TEXT PRIMARY KEY, TenLoi TEXT)";
        sqLiteDatabase.execSQL(QuanLyLoiNhac);

        // Nhac
        String QuanLyNhac = "CREATE TABLE Nhac(MaNhac TEXT PRIMARY KEY, TenNhac TEXT, MaLoai TEXT, MaTacGia TEXT, MaCaSi TEXT, MaLoi TEXT," +
                "FOREIGN KEY(MaLoai) REFERENCES TheLoai(MaLoai)," +
                "FOREIGN KEY(MaTacGia) REFERENCES TacGia(MaTacGia)," +
                "FOREIGN KEY(MaCaSi) REFERENCES CaSi(MaCaSi)," +
                "FOREIGN KEY(MaLoi) REFERENCES LoiNhac(MaLoi))";
        sqLiteDatabase.execSQL(QuanLyNhac);

        // User
        String QuanLyUser = "CREATE TABLE User(MaUser TEXT PRIMARY KEY, TenUser TEXT, Gmail TEXT, MatKhau TEXT, GioiTinh TEXT, NamSinh TEXT, DiaChi TEXT, role INTEGER)";
        sqLiteDatabase.execSQL(QuanLyUser);

        // PlayList
        String QuanLyPlayList = "CREATE TABLE PlayList(MaPlayList TEXT PRIMARY KEY, MaUser TEXT," +
                "FOREIGN KEY(MaUser) REFERENCES User(MaUser))";
        sqLiteDatabase.execSQL(QuanLyPlayList);

        // DanhSachPlayList
        String QuanLyDanhSachPlaylist = "CREATE TABLE DanhSachPlaylist(MaDanhSachPlayList TEXT PRIMARY KEY, MaNhac TEXT," +
                "FOREIGN KEY(MaNhac) REFERENCES Nhac(MaNhac))";
        sqLiteDatabase.execSQL(QuanLyDanhSachPlaylist);

        // Insert sample data
        insertSampleData(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS User");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DanhSachPlaylist");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PlayList");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Nhac");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TheLoai");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TacGia");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CaSi");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LoiNhac");
            onCreate(sqLiteDatabase);
        }
    }

    private void insertSampleData(SQLiteDatabase sqLiteDatabase) {
        // Insert sample data into TheLoai
        String insertTheLoai1 = "INSERT INTO TheLoai (MaLoai, TenLoai, MauTheLoai) " +
                "VALUES ('L1', 'Pop', 'Red')";
        String insertTheLoai2 = "INSERT INTO TheLoai (MaLoai, TenLoai, MauTheLoai) " +
                "VALUES ('L2', 'Rock', 'Blue')";
        sqLiteDatabase.execSQL(insertTheLoai1);
        sqLiteDatabase.execSQL(insertTheLoai2);

        // Insert sample data into TacGia
        String insertTacGia1 = "INSERT INTO TacGia (MaTacGia, TenTacGia, NamSinh, QueQuan) " +
                "VALUES ('TG1', 'Nguyen Nhat Anh', '1955', 'Quang Nam')";
        String insertTacGia2 = "INSERT INTO TacGia (MaTacGia, TenTacGia, NamSinh, QueQuan) " +
                "VALUES ('TG2', 'To Huu', '1920', 'Thua Thien Hue')";
        sqLiteDatabase.execSQL(insertTacGia1);
        sqLiteDatabase.execSQL(insertTacGia2);

        // Insert sample data into CaSi
        String insertCaSi1 = "INSERT INTO CaSi (MaCaSi, TenCaSi, QueQuan, NamSinh, HinhCaSi) " +
                "VALUES ('CS1', 'Son Tung M-TP', 'Thai Binh', '1994', 'son_tung.jpg')";
        String insertCaSi2 = "INSERT INTO CaSi (MaCaSi, TenCaSi, QueQuan, NamSinh, HinhCaSi) " +
                "VALUES ('CS2', 'My Tam', 'Da Nang', '1981', 'my_tam.jpg')";
        sqLiteDatabase.execSQL(insertCaSi1);
        sqLiteDatabase.execSQL(insertCaSi2);

        // Insert sample data into LoiNhac
        String insertLoiNhac1 = "INSERT INTO LoiNhac (MaLoi, TenLoi) " +
                "VALUES ('Loi1', 'Loi nhac 1')";
        String insertLoiNhac2 = "INSERT INTO LoiNhac (MaLoi, TenLoi) " +
                "VALUES ('Loi2', 'Loi nhac 2')";
        sqLiteDatabase.execSQL(insertLoiNhac1);
        sqLiteDatabase.execSQL(insertLoiNhac2);

        // Insert sample data into Nhac
        String insertNhac1 = "INSERT INTO Nhac (MaNhac, TenNhac, MaLoai, MaTacGia, MaCaSi, MaLoi) " +
                "VALUES ('N1', 'Bai Hat 1', 'L1', 'TG1', 'CS1', 'Loi1')";
        String insertNhac2 = "INSERT INTO Nhac (MaNhac, TenNhac, MaLoai, MaTacGia, MaCaSi, MaLoi) " +
                "VALUES ('N2', 'Bai Hat 2', 'L2', 'TG2', 'CS2', 'Loi2')";
        sqLiteDatabase.execSQL(insertNhac1);
        sqLiteDatabase.execSQL(insertNhac2);

        // Insert sample data into User
        // 1 la user
        // 2 la admin
        String insertUser1 = "INSERT INTO User (MaUser, TenUser, Gmail, MatKhau, GioiTinh, NamSinh, DiaChi, role) " +
                "VALUES ('U1', 'Đặng Thị Thu Thảo', 'tannie1101999@gmail.com', '123456', 'Nữ', '1999', 'Vĩnh Long', 1)";
        String insertUser2 = "INSERT INTO User (MaUser, TenUser, Gmail, MatKhau, GioiTinh, NamSinh, DiaChi, role) " +
                "VALUES ('U2', 'Nguyễn Công Thành', 'congthanhnguyen041199@gmail.com','123456', 'Nam', '1999', 'Vũng Tàu', 2)";
        sqLiteDatabase.execSQL(insertUser1);
        sqLiteDatabase.execSQL(insertUser2);
// Insert sample data into PlayList
        String insertPlayList1 = "INSERT INTO PlayList (MaPlayList, MaUser) VALUES ('PL1', 'U1')";
        String insertPlayList2 = "INSERT INTO PlayList (MaPlayList, MaUser) VALUES ('PL2', 'U2')";
        sqLiteDatabase.execSQL(insertPlayList1);
        sqLiteDatabase.execSQL(insertPlayList2);

        // Insert sample data into DanhSachPlaylist
        String insertDanhSachPlaylist1 = "INSERT INTO DanhSachPlaylist (MaDanhSachPlayList, MaNhac) VALUES ('DSP1', 'N1')";
        String insertDanhSachPlaylist2 = "INSERT INTO DanhSachPlaylist (MaDanhSachPlayList, MaNhac) VALUES ('DSP2', 'N2')";
        sqLiteDatabase.execSQL(insertDanhSachPlaylist1);
        sqLiteDatabase.execSQL(insertDanhSachPlaylist2);
    }
}
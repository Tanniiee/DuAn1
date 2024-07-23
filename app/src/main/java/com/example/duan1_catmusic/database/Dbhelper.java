package com.example.duan1_catmusic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelper extends SQLiteOpenHelper {

    public Dbhelper(Context context){

        super(context,"music",null,20);
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
        String QuanLyCaSi = "CREATE TABLE CaSi(MaCaSi TEXT PRIMARY KEY, TenCaSi TEXT, QueQuan TEXT, NamSinh TEXT, HinhCaSi TEXT,Hinhalbum TEXT)";
        sqLiteDatabase.execSQL(QuanLyCaSi);

        // LoiNhac
        String QuanLyLoiNhac = "CREATE TABLE LoiNhac(MaLoi TEXT PRIMARY KEY, TenLoi TEXT)";
        sqLiteDatabase.execSQL(QuanLyLoiNhac);

        // Nhac
        String QuanLyNhac = "CREATE TABLE Nhac(MaNhac TEXT PRIMARY KEY,HinhNhac TEXT, TenNhac TEXT, MaLoai TEXT, MaTacGia TEXT, MaCaSi TEXT, MaLoi TEXT, FileNhac TEXT," +
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
        String QuanLyDanhSachPlaylist = "CREATE TABLE DanhSachPlaylist(MaDanhSachPlayList TEXT PRIMARY KEY, MaNhac TEXT,TenDSPlaylist TEXT,HINH TEXT," +
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
        String insertTheLoai3 = "INSERT INTO TheLoai (MaLoai, TenLoai, MauTheLoai) " +
                "VALUES ('L3', 'Nhạc', 'Blue')";
        String insertTheLoai4 = "INSERT INTO TheLoai (MaLoai, TenLoai, MauTheLoai) " +
                "VALUES ('L4', 'Sự Kiện Trực Tiếp', 'Blue')";
        String insertTheLoai5 = "INSERT INTO TheLoai (MaLoai, TenLoai, MauTheLoai) " +
                "VALUES ('L5', 'Dành cho bạn', 'Blue')";
        String insertTheLoai6 = "INSERT INTO TheLoai (MaLoai, TenLoai, MauTheLoai) " +
                "VALUES ('L6', 'Nhạc Việt', 'Blue')";

        sqLiteDatabase.execSQL(insertTheLoai1);
        sqLiteDatabase.execSQL(insertTheLoai2);
        sqLiteDatabase.execSQL(insertTheLoai3);
        sqLiteDatabase.execSQL(insertTheLoai4);
        sqLiteDatabase.execSQL(insertTheLoai5);
        sqLiteDatabase.execSQL(insertTheLoai6);

        // Insert sample data into TacGia
        String insertTacGia1 = "INSERT INTO TacGia (MaTacGia, TenTacGia, NamSinh, QueQuan) " +
                "VALUES ('TG1', 'Nguyen Nhat Anh', '1955', 'Quang Nam')";
        String insertTacGia2 = "INSERT INTO TacGia (MaTacGia, TenTacGia, NamSinh, QueQuan) " +
                "VALUES ('TG2', 'To Huu', '1920', 'Thua Thien Hue')";
        String insertTacGia3 = "INSERT INTO TacGia (MaTacGia, TenTacGia, NamSinh, QueQuan) " +
                "VALUES ('TG3', 'Taylor Swift', '1989', 'USA')";
        sqLiteDatabase.execSQL(insertTacGia1);
        sqLiteDatabase.execSQL(insertTacGia2);
        sqLiteDatabase.execSQL(insertTacGia3);

        // Insert sample data into CaSi
        String insertCaSi1 = "INSERT INTO CaSi (MaCaSi, TenCaSi, QueQuan, NamSinh, HinhCaSi,Hinhalbum) " +
                "VALUES ('CS1', 'Black Pink', 'Hàn Quốc', '2016', 'blackpink','stayloralbum')";
        String insertCaSi2 = "INSERT INTO CaSi (MaCaSi, TenCaSi, QueQuan, NamSinh, HinhCaSi,Hinhalbum) " +
                "VALUES ('CS2', 'Jennie', 'Hàn Quốc', '1996', 'jenni','jennialbum')";
        String insertCaSi3 = "INSERT INTO CaSi (MaCaSi, TenCaSi, QueQuan, NamSinh, HinhCaSi,Hinhalbum) " +
                "VALUES ('CS3', 'Jiso', 'Hàn Quốc', '1995', 'jiso','jisoalbum')";
        String insertCaSi4 = "INSERT INTO CaSi (MaCaSi, TenCaSi, QueQuan, NamSinh, HinhCaSi,Hinhalbum) " +
                "VALUES ('CS4', 'Jungkook', 'Hàn Quốc', '1995', 'jungkook','vvalbum')";
        String insertCaSi5 = "INSERT INTO CaSi (MaCaSi, TenCaSi, QueQuan, NamSinh, HinhCaSi,Hinhalbum) " +
                "VALUES ('CS5', 'Lisa', 'Thái Lan', '1997', 'lisa','lisaalbum')";
        String insertCaSi6 = "INSERT INTO CaSi (MaCaSi, TenCaSi, QueQuan, NamSinh, HinhCaSi,Hinhalbum) " +
                "VALUES ('CS6', 'Rosé', 'Úc', '1997', 'rose','rosealbum')";
        String insertCaSi7 = "INSERT INTO CaSi (MaCaSi, TenCaSi, QueQuan, NamSinh, HinhCaSi,Hinhalbum) " +
                "VALUES ('CS7', 'Rosé', 'Úc', '1997', 'rose','rosealbum')";
        String insertCaSi8 = "INSERT INTO CaSi (MaCaSi, TenCaSi, QueQuan, NamSinh, HinhCaSi,Hinhalbum) " +
                "VALUES ('CS8', 'V-BTS', 'Hàn Quốc', '1994', 'v','valbum')";
        String insertCaSi9 = "INSERT INTO CaSi (MaCaSi, TenCaSi, QueQuan, NamSinh, HinhCaSi,Hinhalbum) " +
                "VALUES ('CS9', 'Taylor Swift', 'USA', '1989', 'taylor','stayloralbum')";
        sqLiteDatabase.execSQL(insertCaSi1);
        sqLiteDatabase.execSQL(insertCaSi2);
        sqLiteDatabase.execSQL(insertCaSi3);
        sqLiteDatabase.execSQL(insertCaSi4);
        sqLiteDatabase.execSQL(insertCaSi5);
        sqLiteDatabase.execSQL(insertCaSi6);
        sqLiteDatabase.execSQL(insertCaSi7);
        sqLiteDatabase.execSQL(insertCaSi8);
        sqLiteDatabase.execSQL(insertCaSi9);

        // Insert sample data into LoiNhac
        String insertLoiNhac1 = "INSERT INTO LoiNhac (MaLoi, TenLoi) " +
                "VALUES ('Loi1', 'Loi nhac 1')";
        String insertLoiNhac2 = "INSERT INTO LoiNhac (MaLoi, TenLoi) " +
                "VALUES ('Loi2', 'Loi nhac 2')";
        sqLiteDatabase.execSQL(insertLoiNhac1);
        sqLiteDatabase.execSQL(insertLoiNhac2);

        // Insert sample data into Nhac
        String insertNhac1 = "INSERT INTO Nhac (MaNhac, HinhNhac, TenNhac, MaLoai, MaTacGia, MaCaSi, MaLoi, FileNhac) " +
                "VALUES ('N1','killthislove' ,'Kill This Love', 'L1', 'TG1', 'CS1', 'Loi1', 'musictest')";
        String insertNhac2 = "INSERT INTO Nhac (MaNhac, HinhNhac, TenNhac, MaLoai, MaTacGia, MaCaSi, MaLoi, FileNhac) " +
                "VALUES ('N2', 'stay_backpink' , 'Stay', 'L2', 'TG2', 'CS2', 'Loi2', 'file2')";
        String insertNhac3 = "INSERT INTO Nhac (MaNhac, HinhNhac, TenNhac, MaLoai, MaTacGia, MaCaSi, MaLoi, FileNhac) " +
                "VALUES ('N3', 'howyoulikethat' , 'How You Like That', 'L3', 'TG3', 'CS3', 'Loi3', 'file3')";
        String insertNhac4 = "INSERT INTO Nhac (MaNhac, HinhNhac, TenNhac, MaLoai, MaTacGia, MaCaSi, MaLoi, FileNhac) " +
                "VALUES ('N4', 'lovesick' , 'Lovesick Girl', 'L4', 'TG4', 'CS4', 'Loi4', 'file4')";
        String insertNhac5 = "INSERT INTO Nhac (MaNhac, HinhNhac, TenNhac, MaLoai, MaTacGia, MaCaSi, MaLoi, FileNhac) " +
                "VALUES ('N5', 'album1' , 'Bai Hat 5', 'L5', 'TG5', 'CS5', 'Loi5', 'file5')";
        sqLiteDatabase.execSQL(insertNhac1);
        sqLiteDatabase.execSQL(insertNhac2);
        sqLiteDatabase.execSQL(insertNhac3);
        sqLiteDatabase.execSQL(insertNhac4);
        sqLiteDatabase.execSQL(insertNhac5);

        // Insert sample data into User
        String insertUser1 = "INSERT INTO User (MaUser, TenUser, Gmail, MatKhau, GioiTinh, NamSinh, DiaChi, role) " +
                "VALUES ('U1', 'Đặng Thị Thu Thảo', 'tannie1101999@gmail.com', '123456', 'Nữ', '1999', 'Vĩnh Long', 1)";
        String insertUser2 = "INSERT INTO User (MaUser, TenUser, Gmail, MatKhau, GioiTinh, NamSinh, DiaChi, role) " +
                "VALUES ('U2', 'admin', 'admin@gmail.com','123456', 'Nam', '1999', 'Vũng Tàu', 2)";
        sqLiteDatabase.execSQL(insertUser1);
        sqLiteDatabase.execSQL(insertUser2);

        // Insert sample data into PlayList
        String insertPlayList1 = "INSERT INTO PlayList (MaPlayList, MaUser) VALUES ('PL1', 'U1')";
        String insertPlayList2 = "INSERT INTO PlayList (MaPlayList, MaUser) VALUES ('PL2', 'U2')";
        sqLiteDatabase.execSQL(insertPlayList1);
        sqLiteDatabase.execSQL(insertPlayList2);

        // Insert sample data into DanhSachPlaylist
        String insertDanhSachPlaylist1 = "INSERT INTO DanhSachPlaylist (MaDanhSachPlayList, MaNhac, TenDSPlaylist, HINH) " +
                "VALUES ('DSP1', 'N1', 'New music Friday VN', 'album1')";
        String insertDanhSachPlaylist2 = "INSERT INTO DanhSachPlaylist (MaDanhSachPlayList, MaNhac, TenDSPlaylist, HINH) " +
                "VALUES ('DSP2', 'N2', 'Discover Weekly', 'album2')";
        String insertDanhSachPlaylist3 = "INSERT INTO DanhSachPlaylist (MaDanhSachPlayList, MaNhac, TenDSPlaylist, HINH) " +
                "VALUES ('DSP3', 'N3', 'Mới Ra Lò', 'album3')";
        String insertDanhSachPlaylist4 = "INSERT INTO DanhSachPlaylist (MaDanhSachPlayList, MaNhac, TenDSPlaylist, HINH) " +
                "VALUES ('DSP4', 'N4', 'Đẳng Cấp', 'album4')";
        String insertDanhSachPlaylist5 = "INSERT INTO DanhSachPlaylist (MaDanhSachPlayList, MaNhac, TenDSPlaylist, HINH) " +
                "VALUES ('DSP5', 'N5', 'Yêu Thích', 'album5')";
        sqLiteDatabase.execSQL(insertDanhSachPlaylist1);
        sqLiteDatabase.execSQL(insertDanhSachPlaylist2);
        sqLiteDatabase.execSQL(insertDanhSachPlaylist3);
        sqLiteDatabase.execSQL(insertDanhSachPlaylist4);
        sqLiteDatabase.execSQL(insertDanhSachPlaylist5);
    }

}
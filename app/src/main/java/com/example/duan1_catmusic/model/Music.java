package com.example.duan1_catmusic.model;

public class Music {
//    MaNhac, TenNhac, MaLoai, MaTacGia, MaCaSi, MaLoi, FileNhac
    private String MaNhac;
    private String HinhNhac;
    private String TenNhac;
    private String MaLoai;
    private String MaTacGia;
    private String MaCaSi;
    private String MaLoi;
    private String FileNhac;


    public Music(String maNhac, String hinhNhac, String tenNhac, String maLoai, String maTacGia, String maCaSi, String maLoi, String fileNhac) {
        MaNhac = maNhac;
        HinhNhac = hinhNhac;
        TenNhac = tenNhac;
        MaLoai = maLoai;
        MaTacGia = maTacGia;
        MaCaSi = maCaSi;
        MaLoi = maLoi;
        FileNhac = fileNhac;
    }

    public String getMaNhac() {
        return MaNhac;
    }

    public void setMaNhac(String maNhac) {
        MaNhac = maNhac;
    }

    public String getHinhNhac() {
        return HinhNhac;
    }

    public void setHinhNhac(String hinhNhac) {
        HinhNhac = hinhNhac;
    }

    public String getTenNhac() {
        return TenNhac;
    }

    public void setTenNhac(String tenNhac) {
        TenNhac = tenNhac;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String maLoai) {
        MaLoai = maLoai;
    }

    public String getMaTacGia() {
        return MaTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        MaTacGia = maTacGia;
    }

    public String getMaCaSi() {
        return MaCaSi;
    }

    public void setMaCaSi(String maCaSi) {
        MaCaSi = maCaSi;
    }

    public String getMaLoi() {
        return MaLoi;
    }

    public void setMaLoi(String maLoi) {
        MaLoi = maLoi;
    }

    public String getFileNhac() {
        return FileNhac;
    }

    public void setFileNhac(String fileNhac) {
        FileNhac = fileNhac;
    }
}

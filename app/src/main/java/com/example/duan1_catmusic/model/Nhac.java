package com.example.duan1_catmusic.model;


public class Nhac {
    private String maNhac;
    private String hinhNhac;
    private String tenNhac;
    private String maLoai;
    private String maTacGia;
    private String maCaSi;
    private String maLoi;
    private String fileNhac;

    public Nhac(String maNhac, String hinhNhac, String tenNhac, String maLoai, String maTacGia, String maCaSi, String maLoi, String fileNhac) {
        this.maNhac = maNhac;
        this.hinhNhac = hinhNhac;
        this.tenNhac = tenNhac;
        this.maLoai = maLoai;
        this.maTacGia = maTacGia;
        this.maCaSi = maCaSi;
        this.maLoi = maLoi;
        this.fileNhac = fileNhac;
    }

    public String getMaNhac() {
        return maNhac;
    }

    public String getHinhNhac() {
        return hinhNhac;
    }

    public String getTenNhac() {
        return tenNhac;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public String getMaCaSi() {
        return maCaSi;
    }

    public String getMaLoi() {
        return maLoi;
    }

    public String getFileNhac() {
        return fileNhac;
    }
}

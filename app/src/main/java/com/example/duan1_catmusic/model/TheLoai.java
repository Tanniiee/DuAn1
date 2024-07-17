package com.example.duan1_catmusic.model;

public class TheLoai {

    private int MaLoai;

    private String TenLoai;

    private String MauTheLoai;

    public TheLoai(int maLoai, String tenLoai, String mauTheLoai) {
        MaLoai = maLoai;
        TenLoai = tenLoai;
        MauTheLoai = mauTheLoai;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String tenLoai) {
        TenLoai = tenLoai;
    }

    public String getMauTheLoai() {
        return MauTheLoai;
    }

    public void setMauTheLoai(String mauTheLoai) {
        MauTheLoai = mauTheLoai;
    }
}

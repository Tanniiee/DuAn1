package com.example.duan1_catmusic.model;

import java.io.Serializable;

public class casi implements Serializable {

    private int MaCaSi;

    private String TenCaSi;

    private String QueQuan;

    private String NamSinh;

    private String HinhCaSi;

    public casi(int maCaSi, String tenCaSi, String queQuan, String namSinh, String hinhCaSi) {
        MaCaSi = maCaSi;
        TenCaSi = tenCaSi;
        QueQuan = queQuan;
        NamSinh = namSinh;
        HinhCaSi = hinhCaSi;
    }

    public int getMaCaSi() {
        return MaCaSi;
    }

    public void setMaCaSi(int maCaSi) {
        MaCaSi = maCaSi;
    }

    public String getTenCaSi() {
        return TenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        TenCaSi = tenCaSi;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String namSinh) {
        NamSinh = namSinh;
    }

    public String getHinhCaSi() {
        return HinhCaSi;
    }

    public void setHinhCaSi(String hinhCaSi) {
        HinhCaSi = hinhCaSi;
    }
}

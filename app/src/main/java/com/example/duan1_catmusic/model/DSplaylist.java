package com.example.duan1_catmusic.model;

import java.io.Serializable;

public class DSplaylist implements Serializable {

    private String MaDanhSachPlayList;

    private String MaNhac;

    private String TenDSPlaylist;

    private String HINH;


    public DSplaylist(String maDanhSachPlayList, String HINH, String tenDSPlaylist, String maNhac) {
        MaDanhSachPlayList = maDanhSachPlayList;
        this.HINH = HINH;
        TenDSPlaylist = tenDSPlaylist;
        MaNhac = maNhac;
    }

    public String getMaDanhSachPlayList() {
        return MaDanhSachPlayList;
    }

    public void setMaDanhSachPlayList(String maDanhSachPlayList) {
        MaDanhSachPlayList = maDanhSachPlayList;
    }

    public String getMaNhac() {
        return MaNhac;
    }

    public void setMaNhac(String maNhac) {
        MaNhac = maNhac;
    }

    public String getTenDSPlaylist() {
        return TenDSPlaylist;
    }

    public void setTenDSPlaylist(String tenDSPlaylist) {
        TenDSPlaylist = tenDSPlaylist;
    }

    public String getHINH() {
        return HINH;
    }

    public void setHINH(String HINH) {
        this.HINH = HINH;
    }
}

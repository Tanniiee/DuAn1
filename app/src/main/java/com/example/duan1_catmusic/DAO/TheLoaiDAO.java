package com.example.duan1_catmusic.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_catmusic.database.Dbhelper;
import com.example.duan1_catmusic.model.TheLoai;
import com.example.duan1_catmusic.model.casi;

import java.util.ArrayList;

public class TheLoaiDAO {


    private Dbhelper dbHelper;
    public TheLoaiDAO(Context context){
        dbHelper = new Dbhelper(context);
    }



    public ArrayList<TheLoai> getTheLoai(){
        ArrayList<TheLoai> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM TheLoai", null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                list.add(new TheLoai(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)));
            }while (cursor.moveToNext());
        }

        return list;
    }
}

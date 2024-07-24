package com.example.duan1_catmusic.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_catmusic.database.Dbhelper;
import com.example.duan1_catmusic.model.Nhac;
import com.example.duan1_catmusic.model.Nhac;
import com.example.duan1_catmusic.model.casi;

import java.util.ArrayList;

public class nhacDAO {
    private Dbhelper dbHelper;
    public nhacDAO(Context context){
        dbHelper = new Dbhelper(context);
    }



    public ArrayList<Nhac> getnhac(){
        ArrayList<Nhac> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Nhac", null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                list.add(new Nhac(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7)));
            }while (cursor.moveToNext());
        }

        return list;
    }
}

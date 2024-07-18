package com.example.duan1_catmusic.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_catmusic.database.Dbhelper;
import com.example.duan1_catmusic.model.DSplaylist;
import com.example.duan1_catmusic.model.casi;

import java.util.ArrayList;

public class DSplaylistDAO {

    private Dbhelper dbHelper;
    public DSplaylistDAO(Context context){
        dbHelper = new Dbhelper(context);
    }


    public ArrayList<DSplaylist> getDSplaylist(){
        ArrayList<DSplaylist> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM DanhSachPlaylist", null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                list.add(new DSplaylist(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)));
            }while (cursor.moveToNext());
        }

        return list;
    }
}

package com.example.duan1_catmusic.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_catmusic.database.Dbhelper;
import com.example.duan1_catmusic.model.Casi;

import java.util.ArrayList;

public class casiDAO {

    private Dbhelper dbHelper;
    public casiDAO(Context context){
        dbHelper = new Dbhelper(context);
    }



    public ArrayList<Casi> getcasi(){
        ArrayList<Casi> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM CaSi", null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                list.add(new Casi(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)));
            }while (cursor.moveToNext());
        }

        return list;
    }
}

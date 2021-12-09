package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;

public class databasec extends SQLiteOpenHelper {
    
    private  static  final  String dbname = "pharma.db";
    public String query;


    
    public databasec(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String q ="create table data(sr integer ,name_of_chemist text,town text,cell_no integer,doctor_attached integer,qualification text,cell_no2 integer,product text)";
        db.execSQL(q);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists pharma");
        onCreate(db);

    }

    public Cursor getinfo()
    {
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select doctor_attached from pharma",null);
        return  cursor;
    }

    public  Cursor getSpinnerOneinfo()
    {
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select town from pharma",null);
        return  cursor;
    }

    public Cursor getSpinnerTwoinfo(Object itemAtPosition)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select doctor_attached from pharma where town="+itemAtPosition,null);
        return  cursor;
    }


}

package com.example.niklas.diamaster;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

public class DBHelper extends SQLiteOpenHelper {
public static final String DB_Name = "Dia.db";
public static final String TABLE1_NAME = "Diashow";
public static final String COLUMN1 = "DiaName";
public static final String COLUMN4 = "src";
public static final String TABLE2_NAME = "Angezeigt";
public static final String COLUMN5 = "AnzID";
public static final String COLUMN6 = "DiaName";
public static final String COLUMN8 = "Zeit";
public static final String COLUMN9 = "Text";
public static final String COLUMN10 = "Ton";

public static final String SQL_TABLE1 = "create table " + TABLE1_NAME + "(" + COLUMN1 + " text primary key);";
public static final String SQL_TABLE2 = "create table " + TABLE2_NAME + "(" + COLUMN6 + " text primary key);";



    public DBHelper(Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(SQL_TABLE1);
        db.execSQL(SQL_TABLE2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("drop table if exists " + TABLE1_NAME);
        db.execSQL("drop table if exists " + TABLE2_NAME);
        onCreate(db);
    }
    public boolean insertDia(String diaName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN1, diaName);
        long result1 = db.insert(TABLE1_NAME, null, contentValues);

        if (result1 != -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean insertAnz(String diaName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN6, diaName);
        long result = db.insert(TABLE2_NAME, null, contentValues);

        if (result != -1){
            return true;
        }else{
            return false;
        }
    }

    /*public boolean insertDat(String diaName, String src, String zeit, String text, String ton ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN6, diaName);
        long result1 = db.insert(TABLE2_NAME, null, contentValues);



        if (result1 == -1 ){
            return false;
        }else {
            return true;
        }
    }*/
}

package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class db_helper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "transportMe.db";
    public static final String TABLE_NAME = "chat";
    public static final String COL_1 = "Name";
    public static final String COL_2 = "Email";
    public static final String COL_3 = "Phone";
    public static final String COL_4 = "Message";

    public db_helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (Name Text primary key,Email TEXT,Phone TEXT,Message TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP table if exists "+TABLE_NAME);
    }

    public boolean InsertData(String name,String email,String phone,String msg){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1,name);
        cv.put(COL_2,email);
        cv.put(COL_3,phone);
        cv.put(COL_4,msg);

        long result=db.insert(TABLE_NAME,null,cv);

        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM chat";
        Cursor data = db.rawQuery(query,null);

        return data;
    }

    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);

        db.close();
    }
}

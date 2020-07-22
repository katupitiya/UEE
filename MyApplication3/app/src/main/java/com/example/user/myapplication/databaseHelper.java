package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class databaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "transport4.db";
    public static final String TABLE_NAME = "payment_table";
    public static final String TABLE_NAME1= "ticket_table";
    public static final String TABLE_NAME3= "ticket_table2";
    public static final String TABLE_NAME2= "booking_table";
    public static final String TABLE_NAME4 = "chat";


    public static final String COL_c1 = "Name";
    public static final String COL_c2 = "Email";
    public static final String COL_c3 = "Phone";
    public static final String COL_c4 = "Message";


    public static final String COL_1="ID";
    public static final String COL_2="Name";
    public static final String COL_3="Pno";
    public static final String COL_4="P_N_no";
    public static final String COL_5="Email";
    public static final String COL_6="Amount";

    public static final String COL_t1="ID";
    public static final String COL_t2="start";
    public static final String COL_t3="destination";
    public static final String COL_t4="date";
    public static final String COL_t5="starttime";
    public static final String COL_t6="endtime";
    public static final String COL_t7="price";


    public static final String COL_tt1="ID";
    public static final String COL_tt2="start1";
    public static final String COL_tt3="destination1";
    public static final String COL_tt4="date1";
    public static final String COL_tt5="starttime1";
    public static final String COL_tt6="endtime1";
    public static final String COL_tt7="price1";

    public static final String COL_b1="ID";
    public static final String COL_b4="Amount";

    public databaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Pno TEXT,P_N_no TEXT,Email TEXT,Amount TEXT)");
        db.execSQL("create table " +TABLE_NAME1 +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,start TEXT,destination TEXT,date TEXT,starttime TEXT,endtime TEXT,price TEXT)");
        db.execSQL("create table " + TABLE_NAME2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Amount TEXT )");
        db.execSQL("create table " +TABLE_NAME3 +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,start1 TEXT,destination1 TEXT,date1 TEXT,starttime1 TEXT,endtime1 TEXT,price1 TEXT)");
        //db.execSQL("create table "+TABLE_NAME4+" (Name TEXT PRIMARY KEY,Email TEXT,Phone TEXT,Message TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME3);
        db.execSQL("DROP table if exists "+TABLE_NAME4);
        onCreate(db);
    }


    public boolean InsertDataC(String name,String email,String phone,String msg){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_c1,name);
        cv.put(COL_c2,email);
        cv.put(COL_c4,phone);
        cv.put(COL_c4,msg);

        long result=db.insert(TABLE_NAME4,null,cv);

        if(result==-1)
            return false;
        else
            return true;
    }


    public boolean insertData(String Name,String Pno,String P_N_no,String Email,String Amount){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,Name);
        contentValues.put(COL_3,Pno);
        contentValues.put(COL_4,P_N_no);
        contentValues.put(COL_5,Email);
        contentValues.put(COL_6,Amount);



        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;
    }

    public boolean insertDataticket(String start,String destination,String date,String starttime,String endtime,String price){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_t2,start);
        contentValues.put(COL_t3,destination);
        contentValues.put(COL_t4,date);
        contentValues.put(COL_t5,starttime);
        contentValues.put(COL_t6,endtime);
        contentValues.put(COL_t7,price);



        long result=db.insert(TABLE_NAME1,null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;
    }

    public boolean insertDataticket1(String start,String destination,String date,String starttime,String endtime,String price){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_tt2,start);
        contentValues.put(COL_tt3,destination);
        contentValues.put(COL_tt4,date);
        contentValues.put(COL_tt5,starttime);
        contentValues.put(COL_tt6,endtime);
        contentValues.put(COL_tt7,price);



        long result=db.insert(TABLE_NAME3,null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;
    }



    public boolean insertDataBooking(  String totalamount){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_b4,totalamount);




        long result=db.insert(TABLE_NAME2,null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;
    }



    public Cursor getAllData(String start,String end,String date1){
        SQLiteDatabase db=this.getWritableDatabase();
        String select= "select * from "+TABLE_NAME1 + " where " + COL_t2 + " = ? AND " + COL_t3 + " = ? AND " + COL_t4 + " = ? ";
        //Cursor res= db.rawQuery("select * from "+TABLE_NAME1 + " where " + COL_t2,null);
        Cursor res= db.rawQuery(select,new String[]{start,end,date1});
        return res;
    }

    public Cursor getAllData1(String start,String end,String date1){
        SQLiteDatabase db=this.getWritableDatabase();
        String select= "select * from "+TABLE_NAME3 + " where " + COL_tt2 + " = ? AND " + COL_tt3 + " = ? AND " + COL_tt4 + " = ? ";
        //Cursor res= db.rawQuery("select * from "+TABLE_NAME1 + " where " + COL_t2,null);
        Cursor res= db.rawQuery(select,new String[]{start,end,date1});
        return res;
    }

    public Cursor getAllDatamy(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
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

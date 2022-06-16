package com.example.project;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class MyDatabase extends SQLiteOpenHelper {

    private  static  final  int DATABASE_VERSION = 1;

    private  static  final  String DATABASE_NAME="mydatabase";

    private static final String TABLE_NAME = "fooddata";

    public  MyDatabase(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void  onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE "+TABLE_NAME+ " (namefood TEXT(50) PRIMARY KEY," + "mash TEXT(200)," + " howto TEXT(300));");

        Log.d("Create Table", "Create Table Successfully");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
    //insert data
    public long insertData(String namefood, String mash, String howto){
        try{
            SQLiteDatabase db;
            db = this.getWritableDatabase();
            ContentValues val = new ContentValues();
            val.put("namefood",namefood);
            val.put("mash",mash);
            val.put("howto", howto);
            long rows = db.insert(TABLE_NAME,null,val);
            db.close();
            return rows;
        }catch (Exception e){
            return -1;
        }
    }
    public ArrayList<HashMap<String, String>>SelectAllData(){
        try{
            ArrayList<HashMap<String, String >> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String>map;

            SQLiteDatabase db;
            db = this.getReadableDatabase();

            String strSQL= "SELECT * FROM " + TABLE_NAME;
            Cursor cursor = db.rawQuery(strSQL,null);

            if (cursor != null){
                if (cursor.moveToFirst()){
                    do {
                        map = new HashMap<String, String>();
                        map.put("namefood",cursor.getString(0));
                        map.put("mash",cursor.getString(1));
                        map.put("howto",cursor.getString(2));
                        MyArrList.add(map);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;
        }catch (Exception e){
            return null;
        }

    }
    public long DeleteData(String namefood){
        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase();
            long rows = db.delete(TABLE_NAME, "namefood = ?", new String[]{String.valueOf(namefood)});
            db.close();
            return rows;
        }catch (Exception e){
            return -1;
        }
    }
    public long UpdateData(String namefood, String mash, String howto){
        try{
            SQLiteDatabase db;
            db = this.getWritableDatabase();
            String where = "namefood = ?";
            String[] whereArgs = new String[] {String.valueOf(namefood)};
            ContentValues val = new ContentValues();
            val.put("mash",mash);
            val.put("howto", howto);
            long rows = db.update(TABLE_NAME, val, where, whereArgs);
            db.close();
            return rows;
        }catch (Exception e){
            return -1;
        }
    }
    public ArrayList<HashMap<String,String>> SearchData(String keyword){
        try{
            String tag_name="mash",tag_id = "namefood", tag_tel="howto";
            ArrayList<HashMap<String,String>> MyArrList=new ArrayList<HashMap<String,String>>();
            HashMap<String,String>map;
            SQLiteDatabase db;
            db = this.getReadableDatabase();
            String strSQL= "SELECT * FROM "+TABLE_NAME+ " WHERE "
                    + tag_id + " LIKE "+ "'%"+keyword+"%'" + " OR "
                    + tag_name + " LIKE "+ "'%"+keyword+"%'" + " OR "
                    +tag_tel + " LIKE "+ "'%"+keyword+"%'";
            Cursor cursor = db.rawQuery(strSQL,null);
            if(cursor != null){
                if (cursor.moveToFirst()){
                    do{
                        map = new HashMap<String, String>();
                        map.put("namefood",cursor.getString(0));
                        map.put("mash",cursor.getString(1));
                        map.put("howto",cursor.getString(2));
                        MyArrList.add(map);
                    }while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;
        }catch (Exception e){
            return null;
        }

    }
}

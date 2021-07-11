package com.example.a18arid2979pq1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context,"Students Data", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create Table Students(aridNo Text Primary key,name Text,course Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Students");
    }

    public boolean insertStudentData(String aridNo,String name,String course){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put("aridNo",aridNo);
        content.put("name",name);
        content.put("course",course);
        long result=db.insert("Students",null,content);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }

    public boolean updateStudentData(String aridNo,String name,String course){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put("name",name);
        content.put("course",course);
        Cursor cursor=db.rawQuery("Select * from Students where aridNo=?",new String[] {aridNo});
        if(cursor.getCount()>0){
            long result=db.update("Students",content,"aridNo=?",new String[] {aridNo});
            if(result==-1){
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
    }
}

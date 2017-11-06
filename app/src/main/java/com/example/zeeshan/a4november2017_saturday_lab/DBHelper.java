package com.example.zeeshan.a4november2017_saturday_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Zeeshan on 11/4/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context)
    {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        String insetQuery="insert into mybooks(book_title,book_author,status)values('Book1'," +
                "'Author1','Reading')";
        String myBookQueryCreate="CREATE TABLE  IF NOT EXISTS `mybooks` (\n" +
                "\t`_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`book_title`\tTEXT,\n" +
                "\t`book_author`\tTEXT,\n" +
                "\t`status`\tTEXT\n" +
                ");";

        db.execSQL(insetQuery);
        db.execSQL(myBookQueryCreate);

    }

    public void insetBookInDB(String title,String author,String status){

        SQLiteDatabase db=getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("book_title",title);
        contentValues.put("book_author",author);
        contentValues.put("status",status);
        db.insert("mybooks",null,contentValues);
        db.close();

    }



    public Cursor lisetRecord(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor;
        cursor=db.rawQuery("SELECT _id,book_title,book_author,status from mybooks",null);
        return  cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

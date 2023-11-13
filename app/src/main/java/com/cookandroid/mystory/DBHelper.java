package com.cookandroid.mystory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username TEXT primary key, password TEXT, emailEdit TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int k) {
        db.execSQL("drop Table if exists users");
    }

    public Boolean insertDate(String username, String password, String emailEdit) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("emailEdit", emailEdit);

        long result = db.insert("users", null, contentValues);
        if (result == -1){
            return false;
        } else {
            return true;
        }

    }

    public Boolean checkusername(String username) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[] {username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean checkusernamepassowrd(String username, String password) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?", new String[] {username,password});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }


}


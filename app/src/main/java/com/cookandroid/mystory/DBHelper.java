package com.cookandroid.mystory;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username TEXT primary key, password TEXT, emailEdit TEXT)");

//        db.execSQL("create Table imageitem(imagenum integer primary key, imagename TEXT, imagepay integer, imagedetail TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int k) {
        db.execSQL("drop Table if exists users");

//        db.execSQL("drop Table if exists imageitem");

    }

    // 회원가입
    public Boolean insertDate(String username, String password, String emailEdit) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("emailEdit", emailEdit);

        long result = db.insert("users", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    // 아이템 등록
//    public Boolean imageinsert(String imagename, int imagepay, String imagedetail) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("imagename", imagename);
//        contentValues.put("imagepay", imagepay);
//        contentValues.put("imagedetail", imagedetail);
//
//        long result = db.insert("imageitem", null, contentValues);
//        if (result == -1) {
//            return false;
//        } else {
//            return true;
//        }
//
//    }

    // 회원가입때 아이디 중복 확인
    public Boolean checkusername(String username) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select username from users where username=?", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    // 비밀번호 찾기
    public UserBean selectpw(String username) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select password from users where username = ?", new String[]{username});

        UserBean userBean = new UserBean();

        while (cursor.moveToNext()) {

            if (!cursor.getString(0).equals(null)) {

                userBean.setUsername(cursor.getString(0));
                userBean.setPassword(cursor.getString(1));
                userBean.setEmailEdit(cursor.getString(2));

            }

        }

        return userBean;

    }

    // 로그인 할 때
    public Boolean checkusernamepassowrd(String username, String password) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?", new String[]{username, password});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    // 비밀번호 변경
    public Boolean changepw(String username, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("update users set password = ? where username = ?", new String[]{username, password});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    // 아이디 삭제
    public Boolean deleteuser(String username, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("delete from users where username = ? and password = ?", new String[]{username, password});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }


}


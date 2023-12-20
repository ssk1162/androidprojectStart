package com.cookandroid.mystory.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cookandroid.mystory.UserBean;

public class DBHelper extends SQLiteOpenHelper {

    // context 데이터베이스를 생성할 때 필요한 컨텍스트 객체
    // null 기본적으로 사용되는 커서 팩토리 null을 사용하면 기본 커서 팩토리를 사용
    // version 데이터베이스의 버전 스키마를 변경할 때 업그레이드에 사용
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username TEXT primary key, password TEXT, nickname TEXT, emailEdit TEXT)");

//        db.execSQL("create Table goodsitem(goodsname TEXT primary key, imgblob blob, goodspay TEXT, goodsdetail TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int k) {
        db.execSQL("drop Table if exists users");

//        db.execSQL("drop Table if exists imageitem");

    }

    // 회원가입
    public Boolean insertDate(String username, String password, String nickname, String emailEdit) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("nickname", nickname);
        contentValues.put("emailEdit", emailEdit);

        long result = db.insert("users", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    // 아이템 등록
//    public Boolean imageinsert(String goodsname, String imgname, String goodspay, String goodsdetail) {
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

    // 마이페이지 / 비밀번호 찾기
    public UserBean selectAll(String username) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[]{username});

        UserBean userBean = new UserBean();

        while (cursor.moveToNext()) {

            if (!cursor.getString(0).equals(null)) {

                userBean.setUsername(cursor.getString(0));
                userBean.setPassword(cursor.getString(1));
                userBean.setNickname(cursor.getString(2));
                userBean.setEmailEdit(cursor.getString(3));

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

    // 닉네임 변경
    public Boolean changenick(String username, String password, String nickname) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("update users set nickname = ? where username = ? and password = ?", new String[]{username, password, nickname});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

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


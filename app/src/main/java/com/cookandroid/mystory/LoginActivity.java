package com.cookandroid.mystory;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username1, password1;
    Button btnLogin, btnJoin;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setTitle("로그인");

        username1 = findViewById(R.id.username1);
        password1 = findViewById(R.id.password1);
        btnLogin = findViewById(R.id.btnLogin);
        btnJoin = findViewById(R.id.btnJoin);
        db = new DBHelper(this);

        // 로그인
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String user = username1.getText().toString();
                String pass = password1.getText().toString();

                Boolean userlogin = db.checkusernamepassowrd(user, pass);

                if (user.equals("") || pass.equals("")) {

                    Toast.makeText(LoginActivity.this, "빈칸이 있습니다", Toast.LENGTH_SHORT).show();

                } else if (userlogin == false) {

                    Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();

                } else if (userlogin == true) {

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("user", user);
                    Toast.makeText(getApplicationContext(), user + "님 환영합니다", Toast.LENGTH_SHORT).show();
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();

                }

            }
        });

        // 회원가입
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "회원가입", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

}

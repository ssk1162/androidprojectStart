package com.cookandroid.mystory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.mystory.dbhelper.DBHelper;

public class FindidpwActivity extends AppCompatActivity {

    TextView pwview;
    EditText username2;
    Button namebtn, btnBack2;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_activity);
        setTitle("아이디 / 비밀번호 찾기");

        pwview = findViewById(R.id.pwview);
        namebtn = findViewById(R.id.namebtn);
        btnBack2 = findViewById(R.id.btnBack2);
        username2 = findViewById(R.id.username2);
        db = new DBHelper(this);

        namebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = null;
                String pass = null;
                String user = username2.getText().toString();
                UserBean userBean = db.selectAll(user);

                name = userBean.getUsername();
                pass = userBean.getPassword();

                if (name == null) {

                    pwview.setText("아이디를 찾을 수 없습니다");

                } else {

                    pwview.setText(name + "님 비밀번호는 " + pass + "입니다");

                }

            }
        });

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FindidpwActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

}

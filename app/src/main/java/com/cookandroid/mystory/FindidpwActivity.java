package com.cookandroid.mystory;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FindidpwActivity extends AppCompatActivity {

    TextView pwview;
    EditText username2;
    Button namebtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_activity);
        setTitle("아이디 / 비밀번호 찾기");

        pwview = findViewById(R.id.pwview);
        namebtn = findViewById(R.id.namebtn);
        username2 = findViewById(R.id.username2);
        db = new DBHelper(this);

        namebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username2.getText().toString();
                db.selectpw(user);
                Intent intent = new Intent();
                pwview.setText(intent.getStringExtra("pass"));

            }
        });



    }

}

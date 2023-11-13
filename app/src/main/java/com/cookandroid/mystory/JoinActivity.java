package com.cookandroid.mystory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class JoinActivity extends AppCompatActivity {

    Button btnBack, btnGo;
    EditText username, password, repassword, emailEdit;
    Button btnClick, btnPwClick;
    DBHelper db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_activity);
        setTitle("회원가입");

        btnBack = findViewById(R.id.btnBack);
        btnGo = findViewById(R.id.btnGo);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        btnClick = findViewById(R.id.btnClick);
        btnPwClick = findViewById(R.id.btnPwClick);
        emailEdit = findViewById(R.id.emailEdit);
        db = new DBHelper(this);

//      중복 확인
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    String user = username.getText().toString();
                    Boolean checkuser = db.checkusername(user);

                    if (username.getText().toString().replace(" ", "").equals("")) {

                        Toast.makeText(getApplicationContext(), "아이디 확인해주세요", Toast.LENGTH_SHORT).show();

                    } else if (checkuser == false) {

                        Toast.makeText(getApplicationContext(), "아이디 사용 가능합니다", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(getApplicationContext(), "아이디가 중복입니다", Toast.LENGTH_SHORT).show();

                    }

                } catch (Exception e) {
                    e.printStackTrace();

                    Log.e("TAG", "Exception", e);

                }

                db.close();

            }
        });

//      비밀번호 확인
        btnPwClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (password.getText().toString().replace(" ", "").equals("")) {

                    Toast.makeText(getApplicationContext(), "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();

                } else {

                    if (password.getText().toString().equals(repassword.getText().toString())) {

                        Toast.makeText(getApplicationContext(), "비밀번호가 같습니다", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(getApplicationContext(), "비밀번호가 다름니다", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });

//      회원가입
        db = new DBHelper(this);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (username.getText().toString().replace(" ", "").equals("")) {

                    Toast.makeText(getApplicationContext(), "아이디를 확인해주세요", Toast.LENGTH_SHORT).show();

                } else if (password.getText().toString().replace(" ", "").equals("")) {

                    Toast.makeText(getApplicationContext(), "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();

                } else {

                    String user = username.getText().toString();
                    String pass = password.getText().toString();
                    String email = emailEdit.getText().toString();

                    Boolean insert = db.insertDate(user, pass, email);

                    if (insert == false) {

                        Toast.makeText(getApplicationContext(), "회원가입 실패", Toast.LENGTH_SHORT).show();

                    } else if (insert == true) {

                        Toast.makeText(getApplicationContext(), "회원가입 성공", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        finish();

                    }

                }

                db.close();

            }
        });

//      뒤로가기
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "돌아가기", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

}

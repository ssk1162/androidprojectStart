package com.cookandroid.mystory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.mystory.dbhelper.DBHelper;

public class LoginActivity extends AppCompatActivity {

    EditText username1, password1;
    Button btnLogin, btnJoin, idpwbtn;
    DBHelper db;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setTitle("로그인");

        username1 = findViewById(R.id.username1);
        password1 = findViewById(R.id.password1);
        btnLogin = findViewById(R.id.btnLogin);
        btnJoin = findViewById(R.id.btnJoin);
        idpwbtn = findViewById(R.id.idpwbtn);
        db = new DBHelper(this);

        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

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

                    SharedPreferences.Editor editor = preferences.edit();
                    UserBean userBean = db.selectAll(user);
                    editor.putString("user", userBean.getUsername());
                    editor.putString("email", userBean.getEmailEdit());
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        });

        // 회원가입
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
                finish();

            }
        });

        idpwbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), FindidpwActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }


}

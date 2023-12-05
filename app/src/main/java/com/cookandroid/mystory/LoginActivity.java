package com.cookandroid.mystory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.mystory.databinding.LoginActivityBinding;
import com.cookandroid.mystory.dbhelper.DBHelper;

public class LoginActivity extends AppCompatActivity {

    DBHelper db;
    SharedPreferences preferences;

    private LoginActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("로그인");

        db = new DBHelper(this);

        preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

        // 로그인
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String user = binding.username1.getText().toString();
                String pass = binding.password1.getText().toString();

                Boolean userlogin = db.checkusernamepassowrd(user, pass);

                if (user.equals("") || pass.equals("")) {

                    Toast.makeText(LoginActivity.this, "빈칸이 있습니다", Toast.LENGTH_SHORT).show();

                } else if (userlogin == false) {

                    Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();

                } else if (userlogin == true) {

                    SharedPreferences.Editor editor = preferences.edit();
                    UserBean userBean = db.selectAll(user);
                    editor.putString("nick", userBean.getNickname());
                    editor.putString("email", userBean.getEmailEdit());
                    editor.commit();

                    Toast.makeText(getApplicationContext(), userBean.getNickname() + " : " + userBean.getEmailEdit(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        });

        // 회원가입
        binding.btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
                finish();

            }
        });

        binding.idpwbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, FindidpwActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }


}

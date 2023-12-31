package com.cookandroid.mystory;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cookandroid.mystory.databinding.JoinActivityBinding;
import com.cookandroid.mystory.model.DBHelper;

public class JoinActivity extends AppCompatActivity {

    DBHelper db;

    private JoinActivityBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.join_activity);
        binding.setJoin(this);

        setTitle("회원가입");

        db = new DBHelper(this);

//      중복 확인
        binding.btnClick.setOnClickListener(v -> {
            String user = binding.username.getText().toString();
            Boolean checkuser = db.checkusername(user);

            if (user.replace(" ", "").equals("")) {

                Toast.makeText(getApplicationContext(), "아이디 확인해주세요", Toast.LENGTH_SHORT).show();

            } else if (checkuser == false) {

                Toast.makeText(getApplicationContext(), "아이디 사용 가능합니다", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(getApplicationContext(), "아이디가 중복입니다", Toast.LENGTH_SHORT).show();

            }

            db.close();

        });

//      비밀번호 확인
        binding.btnPwClick.setOnClickListener(v -> {

            String password = binding.password.getText().toString();
            String repassword = binding.repassword.getText().toString();

            if (password.replace(" ", "").equals("")) {

                Toast.makeText(getApplicationContext(), "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();

            } else {

                if (password.equals(repassword)) {

                    Toast.makeText(getApplicationContext(), "비밀번호가 같습니다", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), "비밀번호가 다름니다", Toast.LENGTH_SHORT).show();

                }

            }
        });

//      회원가입
        db = new DBHelper(this);
        binding.btnGo.setOnClickListener(v -> {

            String user = binding.username.getText().toString();
            String password = binding.password.getText().toString();
            String nickname = binding.nickname.getText().toString();
            String emailEdit = binding.emailEdit.getText().toString();

            if (user.replace(" ", "").equals("")) {

                Toast.makeText(getApplicationContext(), "아이디를 확인해주세요", Toast.LENGTH_SHORT).show();

            } else if (password.replace(" ", "").equals("")) {

                Toast.makeText(getApplicationContext(), "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();

            } else if (nickname.replace(" ", "").equals("")) {

                Toast.makeText(getApplicationContext(), "닉네임을 확인해주세요", Toast.LENGTH_SHORT).show();

            } else if (emailEdit.replace(" ", "").equals("")) {

                Toast.makeText(getApplicationContext(), "이메일을 확인해주세요", Toast.LENGTH_SHORT).show();

            } else {

                Boolean insert = db.insertDate(user, password, nickname, emailEdit);

                if (insert == false) {

                    Toast.makeText(getApplicationContext(), "회원가입 실패", Toast.LENGTH_SHORT).show();

                } else if (insert == true) {

                    Toast.makeText(getApplicationContext(), "회원가입 성공", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                }

            }

            db.close();
        });

//      뒤로가기
        binding.btnBack.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "돌아가기", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        });

    }

}

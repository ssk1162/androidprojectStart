package com.cookandroid.mystory;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cookandroid.mystory.databinding.FindActivityBinding;

public class FindidpwActivity extends AppCompatActivity {

    DBHelper db;

    private FindActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.find_activity);
        binding.setFind(this);

        setTitle("아이디 / 비밀번호 찾기");
        db = new DBHelper(this);

        binding.namebtn.setOnClickListener(v -> {
                String user = binding.username2.getText().toString();
                UserBean userBean = db.selectAll(user);

                String name = userBean.getUsername();
                String pass = userBean.getPassword();

                if (name == null) {

                    binding.pwview.setText("아이디를 찾을 수 없습니다");

                } else {

                    binding.pwview.setText(name + "님 비밀번호는 " + pass + "입니다");

                }
        });

        binding.btnBack2.setOnClickListener(v -> {
                Intent intent = new Intent(FindidpwActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
        });

    }

}

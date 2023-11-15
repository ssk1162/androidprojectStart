package com.cookandroid.mystory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    Button btnLogOut;
    TextView viewt;
    LinearLayout home_ly;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인");

        btnLogOut = findViewById(R.id.btnLogOut);
        viewt = findViewById(R.id.viewt);

        Intent msg = getIntent();

        String message = msg.getStringExtra("user");

        viewt.setText(message);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "로그아웃", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        init();
        SettingListener();

        bottomNavigationView.setSelectedItemId(R.id.tab_home);

    }

    private void init() {
        home_ly = findViewById(R.id.home_ly);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    private void SettingListener() {
        bottomNavigationView.setOnItemSelectedListener(new TabSelectedListener());
    }

    class TabSelectedListener implements NavigationBarView.OnItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.tab_home: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_ly, new HomeFragment())
                            .commit();
                    return true;
                }
                case R.id.tab_select: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_ly, new SelectFragment())
                            .commit();
                    return true;
                }
                case R.id.tab_save: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_ly, new SaveFragment())
                            .commit();
                    return true;
                }
                case R.id.tab_mypage: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_ly, new UserFragment())
                            .commit();
                    return true;
                }

            }

            return false;
        }
    }

}
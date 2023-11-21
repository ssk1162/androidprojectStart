package com.cookandroid.mystory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    LinearLayout home_ly;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

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
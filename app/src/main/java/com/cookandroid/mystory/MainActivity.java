package com.cookandroid.mystory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cookandroid.mystory.fragment.HomeFragment;
import com.cookandroid.mystory.fragment.RootFragment;
import com.cookandroid.mystory.fragment.SaveFragment;
import com.cookandroid.mystory.fragment.SelectFragment;
import com.cookandroid.mystory.fragment.UserFragment;
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

                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
                    String nick = sharedPreferences.getString("nick","");

                    if (nick.equals("관리자")) {

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_ly, new RootFragment())
                                .commit();

                    } else if (!nick.equals("관리자")) {

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_ly, new HomeFragment())
                                .commit();

                    }

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
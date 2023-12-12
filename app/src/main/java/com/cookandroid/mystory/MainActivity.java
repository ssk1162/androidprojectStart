package com.cookandroid.mystory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.cookandroid.mystory.databinding.ActivityMainBinding;
import com.cookandroid.mystory.fragment.HomeFragment;
import com.cookandroid.mystory.fragment.SaveFragment;
import com.cookandroid.mystory.fragment.SelectFragment;
import com.cookandroid.mystory.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    SaveFragment saveFragment;
    SelectFragment selectFragment;
    UserFragment userFragment;

    BottomNavigationView bottomNavigationView;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMain(this);

        homeFragment = new HomeFragment();
        saveFragment = new SaveFragment();
        selectFragment = new SelectFragment();
        userFragment = new UserFragment();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.home_ly, homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.tab_home: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_ly, new HomeFragment())
                                .commit();
                        return true;
                    }
                    case R.id.tab_select: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_ly, new SelectFragment())
                                .commit();
                        return true;
                    }
                    case R.id.tab_save: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_ly, new SaveFragment())
                                .commit();
                        return true;
                    }
                    case R.id.tab_mypage: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_ly, new UserFragment())
                                .commit();
                        return true;
                    }
                }
                return false;
            }
        });

    }

}
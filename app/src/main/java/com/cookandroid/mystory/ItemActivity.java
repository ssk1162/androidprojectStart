package com.cookandroid.mystory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    TextView imgname, imgdetail;
    ImageView imageview;
    Button paybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        setTitle("상세페이지");

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("상세페이지");

        imgname = findViewById(R.id.imgname);
        imgdetail = findViewById(R.id.imgdetail);
        imageview = findViewById(R.id.imageview);
        paybtn = findViewById(R.id.paybtn);

        Intent intent = new Intent(this.getIntent());

        String name = intent.getStringExtra("data");

        imgname.setText(name);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home: {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
            }
        return super.onOptionsItemSelected(item);
    }

}
package com.cookandroid.mystory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.cookandroid.mystory.databinding.ActivityItemBinding;

public class ItemActivity extends AppCompatActivity {

    TextView imgdetail;
    Button paybtn;

    private ActivityItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item);
        binding.setItem(this);

        binding.toolBar.setTitle("상세페이지");
        setSupportActionBar(binding.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgdetail = findViewById(R.id.imgdetail);
        paybtn = findViewById(R.id.paybtn);

        Intent intent = new Intent(this.getIntent());

        String name = intent.getStringExtra("word");
        int img = intent.getIntExtra("img", 0);

        binding.imgname.setText(name);
        binding.imageview.setImageResource(img);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home: {
                    Intent intent = new Intent(ItemActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
            }
        return super.onOptionsItemSelected(item);
    }

}
package com.cookandroid.mystory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cookandroid.mystory.databinding.ActivityItemBinding;

public class ItemActivity extends AppCompatActivity {

    TextView imgdetail;
    ImageView imageview;
    Button paybtn;
    private ActivityItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolBar.setTitle("상세페이지");
        binding.toolBar.setBackInvokedCallbackEnabled(true);

        imgdetail = findViewById(R.id.imgdetail);
        imageview = findViewById(R.id.imageview);
        paybtn = findViewById(R.id.paybtn);

        Intent intent = new Intent(this.getIntent());

        String name = intent.getStringExtra("data");

        binding.imgname.setText(name);

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
package com.example.train12306.Londing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.example.train12306.R;

public class ImageIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_image);

        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Intent intent = new Intent(ImageIntent.this, MainActivity.class);
                startActivity(intent);
                finish();
                return false;
            }
        }).sendEmptyMessageDelayed(0,2000);
    }
}

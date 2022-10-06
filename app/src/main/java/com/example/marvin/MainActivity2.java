package com.example.marvin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {

    TextView t1;
    TextView t2;
    TextView t3;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();

        t1 = findViewById(R.id.txt1);
        t2 = findViewById(R.id.txt2);
        t3 = findViewById(R.id.txt3);
        img = findViewById(R.id.imgggggggg);

        Glide.with(this).load(i.getStringExtra("imgggg")).into(img);
        t1.setText(i.getStringExtra("txt1"));
        t2.setText(i.getStringExtra("txt2"));
        t3.setText(i.getStringExtra("txt3"));


    }
}
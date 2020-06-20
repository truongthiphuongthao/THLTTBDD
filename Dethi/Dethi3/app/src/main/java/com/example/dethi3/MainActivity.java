package com.example.dethi3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tinhdiem = (Button) findViewById(R.id.btntinhdiem);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        final Button btnchuyendoi = (Button) findViewById(R.id.btnchuyendoi);
        final Button btntinhdiem = (Button) findViewById(R.id.btntinhdiem);
        Button btnthoat = (Button) findViewById(R.id.btnthoat);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnchuyendoi.setVisibility(View.VISIBLE);
                btntinhdiem.setVisibility(View.VISIBLE);
            }
        });
        tinhdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttinhdiem = new Intent(MainActivity.this, tinhdiemtonghop.class);
                startActivity(intenttinhdiem);
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnchuyendoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentchuyendoi = new Intent(MainActivity.this, chuyendoi.class);
                startActivity(intentchuyendoi);
            }
        });
    }
}

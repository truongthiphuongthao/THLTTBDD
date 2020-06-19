package com.example.de2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnthongbao = (Button) findViewById(R.id.btnthongbao);
        final Button btntinhdiem = (Button) findViewById(R.id.btntinhdiem);
        final Button btnthoat = (Button) findViewById(R.id.btnthoat);
        final TextView txtchude = (TextView) findViewById(R.id.txtchude);
        final TextView txtlichthi = (TextView) findViewById(R.id.txtlichthi);
        final TextView txtluuy = (TextView) findViewById(R.id.txtluuy);
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnthongbao.setVisibility(View.VISIBLE);
                btntinhdiem.setVisibility(View.VISIBLE);
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btntinhdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttb = new Intent(MainActivity.this, tinhdiem.class);
                startActivity(intenttb);
                finish();
            }
        });
        btnthongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtchude.setVisibility(View.VISIBLE);
                txtlichthi.setVisibility(View.VISIBLE);
                txtluuy.setVisibility(View.VISIBLE);
            }
        });

    }
}

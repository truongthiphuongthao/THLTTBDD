package com.example.b4_thao_b1609548;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_text1, btn_text2, btn_text3, btn_text4, btn_text5, btn_thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_text1 = (Button)this.findViewById(R.id.btn_text1);
        btn_text2=(Button)this.findViewById(R.id.btn_text2);
        btn_text3=(Button)this.findViewById(R.id.btn_text3);
        btn_text4=(Button)this.findViewById(R.id.btn_text4);
        btn_text5=(Button)this.findViewById(R.id.btn_text5);
        btn_thoat=(Button)this.findViewById(R.id.btn_thoat);
        btn_text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn1 = new Intent(MainActivity.this, Activity1.class);
                startActivity(btn1);
            }
        });
        btn_text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn2 = new Intent(MainActivity.this, Activity2.class);
                startActivity(btn2);
            }
        });
        btn_text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn3 = new Intent(MainActivity.this, Activity3.class);
                startActivity(btn3);
            }
        });
        btn_text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn4 = new Intent(MainActivity.this, Activity4.class);
                startActivity(btn4);
            }
        });
        btn_text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn5 = new Intent(MainActivity.this, Activity5.class);
                startActivity(btn5);
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}

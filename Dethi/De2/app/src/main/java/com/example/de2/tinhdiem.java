package com.example.de2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class tinhdiem extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhdiem);
        final EditText edtdiemth = (EditText) findViewById(R.id.edtdiemth);
        final EditText edtdiemtn = (EditText) findViewById(R.id.edtdiemtn);
        final EditText edtdiemthith = (EditText) findViewById(R.id.edtdiemthith);
        Button btntieptuc = (Button) findViewById(R.id.btntieptuc);
        Button btndiemtonghop = (Button)findViewById(R.id.btndiemtonghop);
        Button btntrove = (Button) findViewById(R.id.btntrove);
        final EditText edtdiemtonghop = (EditText) findViewById(R.id.edtdiemtonghop);
        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttrove = new Intent(tinhdiem.this, MainActivity.class);
                startActivity(intenttrove);
                finish();
            }
        });
        btndiemtonghop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  diemth = edtdiemth.getText().toString();
                String diemtn = edtdiemtn.getText().toString();
                String diemthith = edtdiemthith.getText().toString();
                Double diemtonghop  = Double.parseDouble(diemth)*0.3 + Double.parseDouble(diemtn)*0.4 + Double.parseDouble(diemthith)*0.3   ;
                edtdiemtonghop.setText(diemtonghop+"");
            }
        });
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtdiemth.setText("");
                edtdiemtn.setText("");
                edtdiemthith.setText("");
                edtdiemtonghop.setText("");
            }
        });
    }
}

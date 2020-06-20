package com.example.dethi3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class tinhdiemtonghop extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhdiemthi);
        final EditText edtdiemth = (EditText) findViewById(R.id.edtdiemth);
        final EditText edtdiemthidienkhuyet = (EditText) findViewById(R.id.edtdiemthidienkhuyet);
        final EditText edtdiemthitracnghiem = (EditText) findViewById(R.id.edtdiemthitracnghiem);
        final EditText edtdiemthithuchanh = (EditText) findViewById(R.id.edtdiemthithuchanh);
        final EditText edtketqua = (EditText) findViewById(R.id.edtketquadiem);
        Button btntieptuc = (Button) findViewById(R.id.btntieptuc);
        Button btndiemtonghop = (Button) findViewById(R.id.btndiemtonghop);
        Button btnthoat = (Button) findViewById(R.id.btnthoat);
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtdiemth.setText("");
                edtdiemthidienkhuyet.setText("");
                edtdiemthitracnghiem.setText("");
                edtdiemthithuchanh.setText("");
                edtketqua.setText("");
            }
        });
        btndiemtonghop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diemth = edtdiemth.getText().toString();
                String diemthidienkhuyet = edtdiemthidienkhuyet.getText().toString();
                String diemthitracnghiem = edtdiemthitracnghiem.getText().toString();
                String diemthithuchanh = edtdiemthithuchanh.getText().toString();
                Double ketqua = Double.parseDouble(diemth)*0.2 +  Double.parseDouble(diemthidienkhuyet)*0.2 + Double.parseDouble(diemthitracnghiem)*0.3+ Double.parseDouble(diemthithuchanh)*0.3;
                edtketqua.setText(ketqua+"");
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

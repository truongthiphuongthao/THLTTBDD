package com.example.homework3_thao_b1609548;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class calculator extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        final EditText edtnhapsoluong = findViewById(R.id.edtnhapsoluong);
        final EditText edtnhapdongia = findViewById(R.id.edtnhapdongia);
        final EditText edtnhaptitlethue = findViewById(R.id.edtnhaptitlethue);
        Button btntinhtien = findViewById(R.id.btntinhtien);
        Button btntieptuc = findViewById(R.id.btntieptuc);
        final EditText edtthanhtien = findViewById(R.id.edtthanhtien);
        Button thoatbanhang = findViewById(R.id.btnthoatbanhang);
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtnhapdongia.setText("");
                edtnhapsoluong.setText("");
                edtnhaptitlethue.setText("");
            }
        });
        btntinhtien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sl = edtnhapsoluong.getText().toString();
                String dg = edtnhapdongia.getText().toString();
                String thue = edtnhaptitlethue.getText().toString();
                float tongtien = 0.3f;
                if (sl.equals("")){
                    Toast.makeText(getApplicationContext(),"Can nhap vao so luong",Toast.LENGTH_SHORT).show();
                }else if(edtnhapdongia.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Can nhap vao don gia",Toast.LENGTH_SHORT).show();
                }else  if(edtnhaptitlethue.getText().toString().equals("")){
                    tongtien = (float) (Integer.parseInt(sl)*Float.parseFloat(dg)+(Integer.parseInt(sl)*Float.parseFloat(dg)*0.1));
                    edtthanhtien.setText(""+tongtien);
                }
                else {
                    tongtien = (Integer.parseInt(sl)*Float.parseFloat(dg)) +(Integer.parseInt(sl)*Float.parseFloat(dg)*Integer.parseInt(thue)/100);
                    edtthanhtien.setText(""+tongtien);
                }
            }
        });
        thoatbanhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}

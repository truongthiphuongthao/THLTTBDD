package com.example.b7_thao_b1609548;

import android.content.Intent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThemSinhVien extends AppCompatActivity {
    DBAdapter db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themsinhvien);
        db = new DBAdapter(this);
        // Them sinh vien
        final EditText mssv = (EditText) this.findViewById(R.id.mssv);
        final EditText ten = (EditText) this.findViewById(R.id.hoten);
        final EditText email = (EditText) this.findViewById(R.id.email);
        final EditText phone = (EditText)this.findViewById(R.id.phone);
        final TextView ct = (TextView) this.findViewById(R.id.studentduocthem);
        Button themsinhvien = (Button)this.findViewById(R.id.btnthem);
        Button trove = (Button)this.findViewById(R.id.btntrove);
        themsinhvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.open();
                String masosv = mssv.getText().toString();
                String hoten = ten.getText().toString();
                String e_mail = email.getText().toString();
                String sdt = phone.getText().toString();
                long id = db.insertStudent(masosv,hoten,e_mail,sdt);
                Cursor c = db.getAllStudents();
                c.moveToLast();
                String txt="id: " +c.getString(0)+"\n"+
                           "MSSV: "+c.getString(1)+"\n"+
                           "Name: "+c.getString(2)+"\n"+
                           "Email: "+c.getString(3)+"\n"+
                           "Phone: "+c.getString(4);
                ct.setText(txt);
                db.close();
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThemSinhVien.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}

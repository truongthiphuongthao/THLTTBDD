package com.example.b7_thao_b1609548;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);
    ListView lv;
    ArrayList<String> arrList=null;
    ArrayAdapter<String>adapter=null;
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button themsv = (Button) this.findViewById(R.id.btnthemsv);
        Button xemtatcasv = (Button) this.findViewById(R.id.btnxemtatca);
        Button suasv = (Button) this.findViewById(R.id.btncapnhatsv);
        Button xemmotsv = (Button) this.findViewById(R.id.btnxemmotsv);
        Button xoasv = (Button)this.findViewById(R.id.btnxoasv);
        Button btntrove = (Button)this.findViewById(R.id.btntrove);
        themsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ThemSinhVien.class);
                startActivity(it);
            }
        });
        lv=(ListView)findViewById(R.id.lvperson);
        arrList=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrList);
        lv.setAdapter(adapter);
        xemtatcasv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.open();
                Cursor c = db.getAllStudents();
                if(c.moveToFirst()){
                    do{
                        String msg ="id: "+c.getString(0)+"\n"+
                                    "MSSV: "+ c.getString(1)+"\n"+
                                    "Name: "+c.getString(2)+"\n"+
                                    "Email: "+c.getString(3)+"\n"+
                                    "Phone: "+c.getString(4);
                        arrList.add(msg);
                        adapter.notifyDataSetChanged();
                        c.moveToNext();
                    }
                    while(c.isAfterLast()==false);
                }
                db.close();
            }
        });
        suasv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SuaSinhVien.class);
                startActivity(i);
            }
        });

        xemmotsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, XemMotSv.class);
                startActivity(i);
            }
        });
        xoasv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, XoaSinhVien.class);
                startActivity(i);
            }
        });
        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}

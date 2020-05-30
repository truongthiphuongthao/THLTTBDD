package com.example.b7_thao_b1609548;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class XemMotSv extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xemmotsinhvien);
        final EditText so = (EditText) this.findViewById(R.id.stt);
        final TextView ct = (TextView) this.findViewById(R.id.hienthi);
        Button xemsv = (Button) this.findViewById(R.id.btnxemmot);
        Button trove = (Button) this.findViewById(R.id.btntrove);
        xemsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.open();
                int chiso = Integer.parseInt(so.getText().toString());
                Cursor cc = db.getStudent(chiso);
                if(cc.moveToFirst()){
                    String tx ="id: "+ cc.getString(0)+"\n"+
                               "MSSV: "+cc.getString(1)+"\n"+
                               "Name: "+cc.getString(2 )+"\n"+
                               "Email: "+cc.getString(3)+"\n"+
                               "Phone: "+cc.getString(4);
                    ct.setText(tx);
                }
                else{
                    String tx2="No student found";
                    ct.setText(tx2);
                    db.close();
                }
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(XemMotSv.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}

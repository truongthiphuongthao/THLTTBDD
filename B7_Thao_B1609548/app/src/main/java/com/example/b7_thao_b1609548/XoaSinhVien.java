package com.example.b7_thao_b1609548;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class XoaSinhVien extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xoasinhvien);
        final EditText so  = (EditText) this.findViewById(R.id.stt);
        final TextView ct = (TextView) this.findViewById(R.id.hienthixoa);
        Button xoasv = (Button) this.findViewById(R.id.btnxoa);
        Button btntrove = (Button) this.findViewById(R.id.btntrove);
        xoasv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.open();
                int chiso = Integer.parseInt(so.getText().toString());
                if(db.deleteStudent(chiso))
                    ct.setText("thành công");
                else
                    ct.setText("không thành công, đổi STT và thực hiện lại.");
                db.close();
            }
        });
        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(XoaSinhVien.this, MainActivity.class);
                startActivity(i);
            }
        });



    }
}

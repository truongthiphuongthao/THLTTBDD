package com.example.b7_thao_b1609548;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SuaSinhVien extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suasinhvien);
        final EditText sott = (EditText) this.findViewById(R.id.stt);
        final EditText masosv = (EditText) this.findViewById(R.id.mssv);
        final EditText ten = (EditText) this.findViewById(R.id.hoten);
        final EditText email = (EditText) this.findViewById(R.id.email);
        final EditText phone = (EditText) this.findViewById(R.id.dt);
        final TextView ct = (TextView) this.findViewById(R.id.capnhat);
        Button suasv = (Button) this.findViewById(R.id.btnsua);
        Button trove = (Button)this.findViewById(R.id.btntrove);
        suasv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.open();
                String masosinhvien = masosv.getText().toString();
                String tensv = ten.getText().toString();
                String e_mail = email.getText().toString();
                String sdt = phone.getText().toString();
                int chiso = Integer.parseInt(sott.getText().toString());
                if(db.updateStudent(chiso, masosinhvien,tensv,e_mail,sdt))
                    ct.setText("thành công");
                else
                    ct.setText("không thành công, đây là giá trị cũ, vui lòng thực hiện lại lần nữa ");
                Cursor c = db.getStudent(chiso);
                String tx ="id: "+c.getString(0)+"\n"+
                           "MSSV: "+c.getString(1)+"\n"+
                           "Name: "+c.getString(2)+"\n"+
                           "Email: "+c.getString(3)+"\n"+
                           "Phone: "+c.getString(4);
                ct.setText(tx);
                db.close();
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SuaSinhVien.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}

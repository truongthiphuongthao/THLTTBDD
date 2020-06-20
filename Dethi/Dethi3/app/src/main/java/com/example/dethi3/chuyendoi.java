package com.example.dethi3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class chuyendoi extends AppCompatActivity {
    CheckBox checkBox;
    EditText edtmg;
    EditText edtmmol;
    TextView txtmg;
    TextView txtmmol;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuyendoi);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        edtmg = (EditText) findViewById(R.id.edtmg);
        edtmmol = (EditText) findViewById(R.id.edtmmol);
        Button btnchuyendoi = (Button) findViewById(R.id.btnchuyendoi);
        txtmg = (TextView) findViewById(R.id.txtmg);
        txtmmol = (TextView) findViewById(R.id.txtmmol);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onUnitChange();
            }
        });
        btnchuyendoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(checkBox.isChecked()){
                     String mg = edtmmol.getText().toString();
                     Double kqmm = Double.parseDouble(mg)*5.5/100;
                     edtmg.setText(kqmm+"");
                 }
                 else{
                     String mm = edtmmol.getText().toString();
                     Double kqmg = Double.parseDouble(mm)*100/5.5;
                     edtmg.setText(kqmg+"");
                 }

            }
        });
        onUnitChange();
    }
    void onUnitChange(){
        if(checkBox.isChecked()){
            txtmmol.setText("mg/dL");
            txtmg.setText("mmol/L");
            edtmg.setText("");
            edtmmol.setText("");
        }
        else {
            txtmmol.setText("mmol/L");
            txtmg.setText("mg/dL");
            edtmg.setText("");
            edtmmol.setText("");
        }
    }
}

package com.example.buoi3_bai3_thao_b1609548;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int request_Code =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickWebBrowser(View view){
        EditText txt_url = (EditText) findViewById(R.id.nhapurl);
        String url = txt_url.getText().toString();
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }
    public void onClickMakeCalls(View view ){
        EditText phone_number = (EditText)findViewById(R.id.nhapnumberphone);
        String pn = phone_number.getText().toString();
        Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+pn));
        startActivity(i);
    }
    public void onClickShowMap(View view){
        EditText position = (EditText) findViewById(R.id.nhapgeo);
        String ps = position.getText().toString();
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:"+ps));
        startActivity(i);
    }

}

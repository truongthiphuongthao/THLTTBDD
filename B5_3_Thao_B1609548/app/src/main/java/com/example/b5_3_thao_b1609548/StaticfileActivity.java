package com.example.b5_3_thao_b1609548;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StaticfileActivity extends AppCompatActivity {
   // EditText textBox;
    TextView textBox;
    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staticfile);
        //textBox = (EditText) findViewById(R.id.txtText1);
        textBox = (TextView) findViewById(R.id.txtText1);
        InputStream is = this.getResources().openRawResource(R.raw.huongdan);
        InputStreamReader ir = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(ir);
        String str = null;

        String text = "";
        try {
            while ((str = br.readLine()) != null) {
               //Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
                // cho nay e doc het cung duoc, cho don gian, ko thi doc tung dong nhu thay cung dc
                text += str;
            }
            is.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textBox.setText(text);

    }
}

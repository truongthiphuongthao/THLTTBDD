package com.example.bai9_thao_b1609548;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btgetAllCallLogs = (Button)findViewById(R.id.btgetAllLogs);
        Button btgetAllContacts = (Button)findViewById(R.id.btgetAllContacts);
        Button btgetAllMusic = (Button)findViewById(R.id.btgetAllMusic);
        btgetAllCallLogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, DisplayAllCallLog.class);
                startActivity(intent1);
            }
        });
        btgetAllContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, DisplayAllContact.class);
                startActivity(intent2);
            }
        });
        btgetAllMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, DisplayMediaList.class);
                startActivity(intent3);
            }
        });
    }
}

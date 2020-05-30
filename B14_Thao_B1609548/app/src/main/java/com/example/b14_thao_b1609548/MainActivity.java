package com.example.b14_thao_b1609548;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView newmessage = (TextView)findViewById(R.id.newmessage);
        TextView inbox = (TextView)findViewById(R.id.inbox);
        final TextView exit = (TextView)findViewById(R.id.exit);
        newmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newmessage = new Intent(MainActivity.this, Newmessage.class);
                startActivity(newmessage);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inbox = new Intent(MainActivity.this, Inbox.class);
                startActivity(inbox);
            }
        });
    }
}

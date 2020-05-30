package com.example.b14_thao_b1609548;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Newmessage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmessage);
        Button btn = (Button)this.findViewById(R.id.send);
        Button exit = (Button)this.findViewById(R.id.exitinbox);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText phone = (EditText)findViewById(R.id.phone);
                EditText message = (EditText)findViewById(R.id.message);
                try{
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(phone.getText().toString(),null,  message.getText().toString(),null,null);
                    Toast toast = Toast.makeText(Newmessage.this,"SMS sent successful", Toast.LENGTH_LONG);
                    toast.show();
                }catch (Exception e){
                    Toast toast = Toast.makeText(Newmessage.this, "Sending SMS failed", Toast.LENGTH_LONG);
                    toast.show();
                    e.printStackTrace();
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

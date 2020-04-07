package com.example.buoi3_bai2_thao_b1609548;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        final EditText receiveValueEdit = (EditText) findViewById(R.id.value_edit);
        final Button callReceiverButton = (Button) findViewById(R.id.call_button);
        // Lấy về Bundle được gửi kèm Intent rồi lấy ra giá trị
        Bundle receiveBundle = this.getIntent().getExtras();
        final long receiveValue = receiveBundle.getLong("value");
        // Hiển thị giá trị lấy về trên EditText
        receiveValueEdit.setText(String.valueOf(receiveValue));
        // Gởi giá trị đến BroadCastReceiver
        callReceiverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // KHởi tạo 1 Intent để gửi tới BroadCast Receiver
                // Gán giá trị vào Intent
                Intent i = new Intent(Activity2.this,Receiver.class);
                i.putExtra("new value",receiveValue-10);
                sendBroadcast(i);
            }
        });
    }
}

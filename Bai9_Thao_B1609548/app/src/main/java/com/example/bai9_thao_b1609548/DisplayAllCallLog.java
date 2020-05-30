package com.example.bai9_thao_b1609548;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;

public class DisplayAllCallLog extends AppCompatActivity {
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayalllog);
        Button btntrove = (Button) findViewById(R.id.btntrove);
        ListView lvlog = (ListView)findViewById(R.id.lvlog);
        ArrayList<String> list2 = new ArrayList<String>();
        ContentResolver cr2 = getContentResolver();
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);
        lvlog.setAdapter(adapter2);
        String[] projection = new String[]{CallLog.Calls.DATE, CallLog.Calls.NUMBER, CallLog.Calls.DURATION};
        if(checkSelfPermission(Manifest.permission.READ_CALL_LOG)!= PackageManager.PERMISSION_GRANTED){
            return;
        }
        Cursor managedCursor = getContentResolver().query(CallLog.Calls.CONTENT_URI, projection,CallLog.Calls.DURATION + "<?", new String[]{"30"},CallLog.Calls.DATE + " Asc");
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration =managedCursor.getColumnIndex(CallLog.Calls.DURATION);
        while (managedCursor.moveToNext()){
            String phNumber = managedCursor.getString(number);
            String callDate = managedCursor.getString(date);
            Date callDayTime = new Date(Long.valueOf(callDate));
            String callDuration = managedCursor.getString(duration);
            String cuocgoi = "Phone Number:--- " + phNumber
                    +" \nCall Type:--- " + "?" + " \nCall Date:--- "
                    + callDayTime + " \nCall duration in sec :---"
                    + callDuration + "\n-----------------------------";
            list2.add(cuocgoi);
            adapter2.notifyDataSetChanged();
        }
        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

package com.example.bai9_thao_b1609548;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import java.util.ArrayList;

public class DisplayMediaList extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayallmedia);
        Button btntrove = (Button)findViewById(R.id.btntrove);
        ListView lvmedia = (ListView)findViewById(R.id.lvmedia);
        ArrayList<String> list = new ArrayList<String>();
        ContentResolver cr = getContentResolver();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        lvmedia.setAdapter(adapter);
        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String []projection={
                MediaStore.MediaColumns.DISPLAY_NAME,
                MediaStore.MediaColumns.DATE_ADDED,
                MediaStore.MediaColumns.MIME_TYPE
        };
        CursorLoader loader = new CursorLoader(this, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projection,null,null,null);
        Cursor c = loader.loadInBackground();
        c.moveToFirst();
        String s="";
        while(!c.isAfterLast()){
            for(int i=0;i<1;i++){
                s+=c.getString(i)+" - ";
            }
            s+="\n";
            list.add(s);
            adapter.notifyDataSetChanged();
            c.moveToNext();
        }
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        c.close();
    }
}

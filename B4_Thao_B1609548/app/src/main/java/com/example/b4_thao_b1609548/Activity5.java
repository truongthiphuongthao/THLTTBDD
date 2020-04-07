package com.example.b4_thao_b1609548;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity5 extends ListActivity {
TextView selection;
String arr[]={"Intel","SamSung","Nokia","Simen","AMD","KIC","ECD"};
ArrayAdapter<String>adapter=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        // Thiết lập Data Source cho Adapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
        // Gán adapter vào ListView
        setListAdapter(adapter);
        selection = (TextView)findViewById(R.id.selection);
    }
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        String txt = "position = "+position+"; value ="+arr[position];
        selection.setText(txt);
    }
}

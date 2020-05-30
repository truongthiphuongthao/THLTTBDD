package com.example.b14_thao_b1609548;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Inbox extends ListActivity {
    private ListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Cursor c = getContentResolver().query(Uri.parse("content://sms/inbox"),null,null,null,null);
        startManagingCursor(c);
        String[] columns = new String[]{"body"};
        int[] names = new int[]{R.id.row};
        adapter= new SimpleCursorAdapter(this, R.layout.activity_inbox,c,columns,names);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long ida) {
        super.onListItemClick(l, v, position, ida);
        Cursor mycursor = (Cursor)getListView().getItemAtPosition(position);
        Toast toast = Toast.makeText(Inbox.this,"From "+mycursor.getString(mycursor.getColumnIndex("address"))+":\n"+mycursor.getString(mycursor.getColumnIndex("body")), Toast.LENGTH_LONG);
        toast.show();
    }
}

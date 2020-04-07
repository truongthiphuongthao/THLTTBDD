package com.example.b4_thao_b1609548;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {
    EditText txtten;
    TextView txtchon;
    Button btn;
    ListView lv;
    ArrayList<String> arrayList=null;
    ArrayAdapter<String> adapter=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        txtten=(EditText)findViewById(R.id.txtTen);
        txtchon=(TextView)findViewById(R.id.txtselection);

        lv = (ListView)findViewById(R.id.lvperson);
        // 1. Tạo ArrayList object
        arrayList = new ArrayList<String>();
        // 2. Gán Data Source (Arraylist object) vào ArrayAdapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        // 3. Gán adapter vào ListView
        lv.setAdapter(adapter);

        btn = (Button)findViewById(R.id.btnNhap);
        // 4. xử lý sự kiện nhấn nút nhập
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(txtten.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });
        // 5. Xử lý sự kiện chọn một phần tử trong ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View agr1, int arg2, long arg3) {
                txtchon.setText("position : "+arg2+"; value="+arrayList.get(arg2));
            }
        });
        // 6. Xử lý sự kiện Long click
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                arrayList.remove(arg2); // xóa phần tử arg2
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}

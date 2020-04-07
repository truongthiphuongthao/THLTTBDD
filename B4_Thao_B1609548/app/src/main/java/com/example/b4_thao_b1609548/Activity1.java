package com.example.b4_thao_b1609548;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        //1. Khởi tạo dữ liệu cho mảng arr (còn gọi là data source)
        final String arr[]={"Nguyen Van Manh","Tran Van Giau","Le Van Sung", "Pham Van Tien"};
        //2.Lấy đối tượng ListView dựa vào id
        ListView lv = (ListView)findViewById(R.id.dssv);
        //3. Gan Data souce vao ArrayAdapter
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arr);
        // 4. Đưa data Source vào List View
        lv.setAdapter(adapter);
        // 5. Khai báo TextView
        final TextView txt = (TextView)findViewById(R.id.svchon);
        // 6. Thiet lap su kien cho ListView, khi chon phan tu nao thi hien thi len TextView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // đổi số arg2 là vị trí trong Data Source(arr)
                txt.setText("position:"+arg2+";value="+arr[arg2]);
            }
        });
    }
}

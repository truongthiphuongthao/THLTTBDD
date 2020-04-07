package com.example.b4_thao_b1609548;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        // 1. Khởi tạo dữ liệu bằng mảng Array
        final String arr[]=getResources().getStringArray(R.array.myarray);
        // 2. Lấy đối tượng ListView dựa vào id
        ListView lv =(ListView)findViewById(R.id.dssv);
        // 3. Gán data source vào ArrayAdapter
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arr);
        // 4. Đưa data source vào ListView
        lv.setAdapter(adapter);
        // 5. Khai báo TextView
        final TextView txt = (TextView) findViewById(R.id.svchon);
        // 6. Thiết lập sự kiện cho ListView, khi chọn phần tử nào thì hiển thị lên TextView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // Đổi số arg2 là vị trí phần tử trong Data Source (arr)
                txt.setText("position:"+arg2+";value="+arr[arg2]);
            }
        });

    }
}

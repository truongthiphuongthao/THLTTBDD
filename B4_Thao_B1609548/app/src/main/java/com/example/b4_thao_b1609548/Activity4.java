package com.example.b4_thao_b1609548;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {
    EditText editId, editName;
    Button btnNhap;
    RadioGroup radgroup;
    ListView lvSinhvien;
    ArrayList<Nhom>arrSinhvien = new ArrayList<Nhom>();
    ArrayAdapter<Nhom>adapter=null;
    // Khai báo 1 sinhvien object
    Nhom sinhvien =null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        editId = (EditText)findViewById(R.id.editMa);
        editName = (EditText)findViewById(R.id.editTen);
        btnNhap = (Button)findViewById(R.id.btnnhap);
        radgroup=(RadioGroup)findViewById(R.id.radiogroup1);
        lvSinhvien=(ListView)findViewById(R.id.lvsinhvien);
        // Đưa data Source là các sinhvien vào Adapter
        adapter = new ArrayAdapter<Nhom>(this, android.R.layout.simple_list_item_1, arrSinhvien);
        // Đưa adapter vào ListView
        lvSinhvien.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processNhap();
            }
        });
    }
    // Xử lý sự kiện nhập
    public void processNhap()
    {
        // Lấy ra đúng id của Radio Button đượcc checked
        int radId = radgroup.getCheckedRadioButtonId();
        String id = editId.getText()+"";
        String name = editName.getText()+"";
        if(radId==R.id.radNhom1)
        {
            // tạo instance là Nhom1
            sinhvien=new Nhom_1();
        }
        else
        {
            // Tạo instance là Nhom2
            sinhvien = new Nhom_2();
        }
        // NHom1 hay Nhom2 thi cung la Sinhvien
        sinhvien.setId(id);
        sinhvien.setName(name);
        // Đưa sinhvien vào ArrayList
        arrSinhvien.add(sinhvien);
        // Cập nhật gioa diện
        adapter.notifyDataSetChanged();
    }
    // Tạo các lớp chức năng để sử dụng trong Activity4
    public abstract class Nhom{
        private String id;
        private String name;

        public String getId(){
            return id;
        }
        public void setId(String id){
            this.id=id;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
        public abstract double TinhThu();
        public String toString(){
            return this.id+" - "+this.name;
        }
    }
    public class Nhom_1 extends Nhom{
        public double TinhThu(){
            return 3;
        }
        public String toString(){
            return super.toString() +" - Nhóm 1 - Thứ"+TinhThu();
        }
    }
    public class Nhom_2 extends Nhom{
        public double TinhThu(){
            return 4;
        }
        public String toString(){
            return super.toString() +" - Nhóm 2 - Thứ"+TinhThu();
        }
    }
}

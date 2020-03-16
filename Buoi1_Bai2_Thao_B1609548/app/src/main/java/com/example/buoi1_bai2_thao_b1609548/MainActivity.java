package com.example.buoi1_bai2_thao_b1609548;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
Button btnmenu, btnpopup, thoat;// khai báo các đối tượng Button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnmenu = (Button) findViewById(R.id.btnmenu);
        btnmenu.setOnCreateContextMenuListener(this);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.showContextMenu();
            }
        });
        btnpopup = (Button) findViewById(R.id.btnpopup);
        thoat = (Button)findViewById(R.id.btnthoat);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        btnpopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu();
            }
        });
    }
    // Tạo Option menu
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    // Xử lý thao tác click chọn item
    public boolean onOptionsItemSelected(MenuItem item){
        // Tải ImageView để khai báo trong Layout để đặt hình vào
      ImageView hinh = (ImageView) findViewById(R.id.img);
      switch (item.getItemId()){
          case R.id.item1:
              hinh.setImageResource(R.drawable.chimp);
              return true;
          case R.id.item2:
              hinh.setImageResource(R.drawable.crowned_crane);
              return true;
          case R.id.item3:
              hinh.setImageResource(R.drawable.dolphin);
              return true;
          case R.id.item4:
              hinh.setImageResource(R.drawable.drake);
              return true;
          default:
              return super.onOptionsItemSelected(item);
      }
    }
    // Tạo ra context menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ngucanh, menu);
    }
    // xử lí click chọn item trên context menu
    public boolean onContextItemSelected(MenuItem item){
//        AdapterView.AdapterContextMenuInfo info =  (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.item1: //
                Toast toast = new Toast(this);
                toast.setGravity(Gravity.CENTER,100,100);
                TextView tv = new TextView(this);
                tv.setBackgroundColor(Color.BLUE);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(25);
                Typeface t = Typeface.create("serif",Typeface.BOLD);
                tv.setTypeface(t);
                tv.setPadding(10,10,10,10);
                tv.setText("Bộ phận tiếp thị; \n Bộ phận nhập hàng; \n Bộ phận giao hàng; \n Bộ phận kế toán;");
                toast.setView(tv);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
                return true;
            case R.id.item2_1:
                Toast toast1 = new Toast(this);
                toast1.setGravity(Gravity.CENTER,100,100);
                TextView tv1 = new TextView(this);
                tv1.setBackgroundColor(Color.BLACK);
                tv1.setTextColor(Color.YELLOW);
                tv1.setTextSize(25);
                Typeface t1 = Typeface.create("serif",Typeface.BOLD);
                tv1.setTypeface(t1);
                tv1.setPadding(10,10,10,10);
                tv1.setText("1. Trần Ngọc Thơ;\n 2. Nguyễn Văn Toàn;\n 3. Lê Thị Hoa;");
                toast1.setView(tv1);
                toast1.setDuration(Toast.LENGTH_LONG);
                toast1.show();
                return true;
            case R.id.item2_2:
                Toast toast2 = new Toast(this);
                toast2.setGravity(Gravity.CENTER,100,100);
                TextView tv2 = new TextView(this);
                tv2.setBackgroundColor(Color.BLACK);
                tv2.setTextColor(Color.YELLOW);
                tv2.setTextSize(25);
                Typeface t2 = Typeface.create("serif",Typeface.BOLD);
                tv2.setTypeface(t2);
                tv2.setPadding(10,10,10,10);
                tv2.setText("1. Nguyễn văn A; \n 2. Lâm Văn Mới;");
                toast2.setView(tv2);
                toast2.setDuration(Toast.LENGTH_LONG);
                toast2.show();
                return true;
            case R.id.item2_3:
                Toast toast3 = new Toast(this);
                toast3.setGravity(Gravity.CENTER,100,100);
                TextView tv3 = new TextView(this);
                tv3.setBackgroundColor(Color.BLACK);
                tv3.setTextColor(Color.YELLOW);
                tv3.setTextSize(25);
                Typeface t3 = Typeface.create("serif",Typeface.BOLD);
                tv3.setTypeface(t3);
                tv3.setPadding(10,10,10,10);
                tv3.setText("1. Trần Văn Bảy; \n 2. Nguyễn Văn Tâm; \n 3. Châu Thành Quí;");
                toast3.setView(tv3);
                toast3.setDuration(Toast.LENGTH_LONG);
                toast3.show();
                return true;
            case R.id.item2_4:
                Toast toast4=new Toast(this);
                toast4.setGravity(Gravity.CENTER,100,100);
                TextView tv4 = new TextView(this);
                tv4.setBackgroundColor(Color.BLACK);
                tv4.setTextColor(Color.YELLOW);
                tv4.setTextSize(25);
                Typeface t4 = Typeface.create("serif", Typeface.BOLD);
                tv4.setTypeface(t4);
                tv4.setPadding(10,10,10,10);
                tv4.setText("1. Lê Thị Lý; \n Trần Ngọc Mai.");
                toast4.setView(tv4);
                toast4.setDuration(Toast.LENGTH_LONG);
                toast4.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    // Tạo Popupmenu
    private void showPopupMenu(){
        // Tạo 1 popupMenu
        PopupMenu popupMenu = new PopupMenu(this, btnpopup);
        // Lấy giao diện Menu trong resource
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        // Lấy trình hành động khi chọn item
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item3_1: btnpopup.setText("MENU COPY");
                    break;
                }
                switch (item.getItemId()){
                    case R.id.item3_2: btnpopup.setText("MENU PAST");
                    break;
                }
                switch (item.getItemId()){
                    case R.id.item3_4:btnpopup.setText("MENU DELETE");
                    break;
                }
                return false;
            }
        });
        popupMenu.show();
    }


}

package com.example.buoi2_thao_b1609548;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import java.lang.reflect.Field;
public class MainActivity extends AppCompatActivity {
 Button bai1, bai2, bai3, bai4, thoat, trove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        VeCoBan ve = new VeCoBan(this);
//        setContentView(ve);
//        View chuyenDong = new ChuyenDong(this);
//        setContentView(chuyenDong);
//          TuongTac tuongTac = new TuongTac(this);
//          setContentView(tuongTac);
//            GamePanel gamePanel = new GamePanel(this);
//            setContentView(gamePanel);
        final FrameLayout hienthi = (FrameLayout) findViewById(R.id.framelayout);
        bai1 = (Button) findViewById(R.id.class1);
        bai2 = (Button) findViewById(R.id.class2);
        bai3 = (Button) findViewById(R.id.class3);
        bai4 = (Button) findViewById(R.id.class4);
        thoat = (Button) findViewById(R.id.button1);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        trove = (Button) findViewById(R.id.button2);
        final VeCoBan ve = new VeCoBan(this);
        final ChuyenDong chuyenDong = new ChuyenDong(this);
        final TuongTac tuongTac = new TuongTac(this);
        final SurfaceView view = new GamePanel(this);

        bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienthi.removeAllViews();
                hienthi.addView(ve);
            }
        });
        bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienthi.removeAllViews();
                hienthi.addView(chuyenDong);
            }
        });

        bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienthi.removeAllViews();
                hienthi.addView(tuongTac);
            }
        });

        bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienthi.removeAllViews();
                hienthi.addView(view);
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    protected void onPause(){
        super.onPause();
    }
    protected void onDestroy(){
        super.onDestroy();
    }
}
// ok
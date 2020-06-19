package com.example.de1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String value = "true";
        final TextView txtkiemtra = (TextView) findViewById(R.id.txtkiemtra);
        final Button btnmo = (Button) findViewById(R.id.btnmo);
        final Button btntat = (Button) findViewById(R.id.btntat);
        Button btnthoat = (Button) findViewById(R.id.btnthoat);

        btnmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               txtkiemtra.setText("Đã mở");
//               boolean value = btnmo.isClickable();
               Intent intentmo = new Intent(MainActivity.this, Activity_2.class);
               intentmo.putExtra("value", "true");
               startActivity(intentmo);
               finish();
            }
        });
        btntat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtkiemtra.setText("Đã tắt");
                boolean value = btntat.isClickable();
                Intent intenttat = new Intent(MainActivity.this, Activity_2.class);
                intenttat.putExtra("value","false" );
                startActivity(intenttat);
                finish();
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });
    }
}

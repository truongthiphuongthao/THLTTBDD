package com.example.de1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle);
        String value = getIntent().getStringExtra("value");
        if(value.equals("true")){
            toggleButton.setText("ON");
            toggleButton.setChecked(true);

        }
        else
            {
            toggleButton.setText("OFF");
            toggleButton.setChecked(false);
        }

        Button btntrove = (Button) findViewById(R.id.btntrove);
        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttrove = new Intent(Activity_2.this, MainActivity.class);
                startActivity(intenttrove);
                finish();
            }
        });
    }
}

package com.example.usingpreferences_thao_b1609548;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UsingPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_preferences);
    }
    public void onClickLoad(View view){
        Intent i = new Intent("com.example.AppPreferenceActivity");
        startActivity(i);
    }
    public void onClickDisplay(View view){
        SharedPreferences appPrefs = getSharedPreferences("appPreferences", MODE_PRIVATE);
        DisplayText(appPrefs.getString("editTextPref", ""));
    }
    public void onClickModify(View view) {
        SharedPreferences appPrefs =    getSharedPreferences("appPreferences",MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = appPrefs.edit();
        prefsEditor.putString("editTextPref", ((EditText)findViewById(R.id.txtString)).getText().toString());
        prefsEditor.commit();
    }
        private void DisplayText(String str) {
        Toast.makeText(getBaseContext(), str,  Toast.LENGTH_LONG).show();
    }
}

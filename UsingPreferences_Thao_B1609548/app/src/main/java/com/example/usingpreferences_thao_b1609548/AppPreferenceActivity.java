package com.example.usingpreferences_thao_b1609548;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;

public class AppPreferenceActivity extends PreferenceActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("appPreferences");
        addPreferencesFromResource(R.xml.myapppreferences);
    }
}

package com.example.b6_thao_b1609548;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.telephony.TelephonyManager.NETWORK_TYPE_EDGE;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLoaiKetNoi = (Button) findViewById(R.id.btnLoaiKetNoi);
        Button btnDuyetWeb = (Button) findViewById(R.id.btnDuyetWeb);
        btnLoaiKetNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCheckConnect();
            }
        });
        btnDuyetWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent duyetWeb = new Intent(MainActivity.this, DuyetWeb.class);
                startActivity(duyetWeb);
            }
        });
    }
    /*public void onClickWebBrowser(View view){
        EditText txt_url = (EditText) findViewById(R.id.editUrl);
        String url = txt_url.getText().toString();
        Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }*/
    // Kiem tra ket noi mang
   public boolean onClickCheckConnect(){
       ConnectivityManager connManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
       NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
       TextView txtView = (TextView) findViewById(R.id.txtView);
       TextView textView1 = (TextView) findViewById(R.id.txtView1);
       // kiem tra loai mang
       TelephonyManager telephonyManager;
       telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
       switch (telephonyManager.getNetworkType()){
           case TelephonyManager.NETWORK_TYPE_GPRS:
           case TelephonyManager.NETWORK_TYPE_EDGE:
           case TelephonyManager.NETWORK_TYPE_CDMA:
           case TelephonyManager.NETWORK_TYPE_1xRTT:
           case TelephonyManager.NETWORK_TYPE_IDEN:
               textView1.setText("2G-");
               break;
           case TelephonyManager.NETWORK_TYPE_UMTS:
           case TelephonyManager.NETWORK_TYPE_EVDO_0:
           case TelephonyManager.NETWORK_TYPE_EVDO_A:
           case TelephonyManager.NETWORK_TYPE_HSDPA:
           case TelephonyManager.NETWORK_TYPE_HSUPA:
           case TelephonyManager.NETWORK_TYPE_HSPA:
           case TelephonyManager.NETWORK_TYPE_EVDO_B:
           case TelephonyManager.NETWORK_TYPE_EHRPD:
           case TelephonyManager.NETWORK_TYPE_HSPAP:
               textView1.setText("3G-");
               break;
           case TelephonyManager.NETWORK_TYPE_LTE:
               textView1.setText("4G-");
               break;
           default:
              textView1.setText("Not Found-");
       }
       if (networkInfo == null) {
           //Toast.makeText(this, "No default network is currently active", Toast.LENGTH_LONG).show();
           txtView.setText("No default network is currently active");
           return false;
       }
       if (!networkInfo.isConnected()) {
          // Toast.makeText(this, "Network is not connected", Toast.LENGTH_LONG).show();
           txtView.setText("Network is not connected");
           return false;
       }
       // Kiem tra ket noi mang
       if (!networkInfo.isAvailable()) {
           //Toast.makeText(this, "Network not available", Toast.LENGTH_LONG).show();
           txtView.setText("Network not available");
           return false;
       }
      // Toast.makeText(this, "Network OK", Toast.LENGTH_LONG).show();
       txtView.setText("Network OK");
       return true;
   }
}
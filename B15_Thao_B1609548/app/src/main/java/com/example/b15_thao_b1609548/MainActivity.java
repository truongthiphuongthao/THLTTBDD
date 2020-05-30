package com.example.b15_thao_b1609548;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    EditText urlImage = null;
    EditText urlText = null;
    public InputStream OpenHttpConnection(String urlString) throws IOException {
        InputStream in = null;
        int response = -1;
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Not an HTTP connection");
        try {
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            response = httpConn.getResponseCode();
            Log.w("Response Code", "" + response);
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        } catch (Exception e) {
            Log.e("Networking", e.getLocalizedMessage());
        }
        return in;
    }
    private Bitmap DownloadImage(String URL){
        Bitmap bitmap = null;
        InputStream in = null;
        try{
            in = OpenHttpConnection(URL);
            if(in==null){
                Log.e("Image URL", "Check connection or URL again!");
                return bitmap;
            }
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        }catch (IOException e){
            Log.e("NetworkingActivity",e.getLocalizedMessage());
        }
        return bitmap;
    }
    public class DownloadImageTask extends AsyncTask<String, Void,Bitmap>{
        protected Bitmap doInBackground(String... urls){
            return DownloadImage(urls[0]);
        }
        @Override
        protected void onPostExecute(Bitmap result) {
            ImageView img = (ImageView)findViewById(R.id.img);
            img.setImageBitmap(result);
            TextView tv = (TextView)findViewById(R.id.tvURLimg);
            if(result!=null)
                tv.setText("Got image.");
            else tv.setText("Can't get image.");
        }
    }
    private String DownloadText(String URL){
        int BUFFER_SIZE = 2000;
        InputStream in = null;
        String str ="";
        try{
            in = OpenHttpConnection(URL);
        }catch (IOException e){
            Log.e("Networking",e.getLocalizedMessage());
            return str;
        }
        if(in==null){
            Log.e("Text URL","Check connection or URL again!");
            return str;
        }
        try{
            InputStreamReader isr = new InputStreamReader(in);
            int charRead;
            char[] inputBuffer = new char[BUFFER_SIZE];
            while((charRead=isr.read(inputBuffer))>0){
                String readString = String.copyValueOf(inputBuffer,0,charRead);
                str+=readString;
                inputBuffer=new char[BUFFER_SIZE];
            }
            in.close();
        }catch (IOException e){
            Log.e("Networking",e.getLocalizedMessage());
            return str;
        }
        return str;
    }
    public class DownloadTextTask extends AsyncTask<String,Void,String>{
        protected String doInBackground(String... urls){
            return DownloadText(urls[0]);
        }
        @Override
        protected void onPostExecute(String result) {
          TextView tv1 = (TextView)findViewById(R.id.tv);
          tv1.setText(result);
          TextView tv = (TextView)findViewById(R.id.tvURLtext);
          if(!result.trim().equals(""))
              tv.setText("Got text.");
          else
              tv.setText("Can't get exit.");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String URL ="http://192.168.43.64/Buoi_6/";
     //   new DownloadImageTask().execute(URL+"cantho_3.png");
       // new DownloadTextTask().execute(URL+"Thuhttpget.txt");

        urlImage = findViewById(R.id.nhapurl1);
        TextView txtDownloadImage = (TextView) findViewById(R.id.tvLoading);
        txtDownloadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlImage.getText().toString();
                new DownloadImageTask().execute(url);
            }
        });
        urlText = findViewById(R.id.nhapurl2);
        TextView txtDownloadText = (TextView)findViewById(R.id.tvLoadtext);
        txtDownloadText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlText.getText().toString();
                new DownloadTextTask().execute(url);
            }
        });

    }
}

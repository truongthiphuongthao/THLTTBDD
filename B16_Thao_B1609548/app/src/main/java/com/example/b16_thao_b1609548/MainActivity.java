package com.example.b16_thao_b1609548;
import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
public class MainActivity extends AppCompatActivity {
    //TextView tv = null;
    public InputStream OpenHttpConnection(PostComponent component) throws IOException {
        InputStream in = null;
        int response = -1;
        URL url = new URL(component.getURL());
        URLConnection conn = url.openConnection();
        if(!(conn instanceof HttpURLConnection))
            throw new IOException("Not an HTTP connection");
        try{
            HttpURLConnection httpConn = (HttpURLConnection)conn;
            httpConn.setReadTimeout(15000);
            httpConn.setConnectTimeout(15000);
            httpConn.setRequestMethod("POST");
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            writer.write(getPostDataString(component.getParam()));
            writer.flush();
            writer.close();
            os.close();
            response = httpConn.getResponseCode();
            Log.w("Response Code","" +response);
            if(response == HttpURLConnection.HTTP_OK){
                in = httpConn.getInputStream();
            }
        }catch (Exception e){
            Log.e("Networking", e.getLocalizedMessage());
        }
        return  in;
    }
   public String getTextInfo(PostComponent component){
        int BUFFER_SIZE = 2000;
        InputStream in = null;
        String str ="";
        try{
            in = OpenHttpConnection(component);
        }catch (IOException e){
            Log.e("Networking",e.getLocalizedMessage());
            return str;
        }
        if(in==null){
            Log.e("URL","Check connection or URL again!");
            return str;
        }
        try{
            InputStreamReader isr = new InputStreamReader(in);
            int charRead;
            char[] inputBuffer = new char[BUFFER_SIZE];
            while((charRead=isr.read(inputBuffer))>0){
                String readString = String.copyValueOf(inputBuffer,0,charRead);
                str+=readString;
                inputBuffer = new char[BUFFER_SIZE];
            }
            in.close();
        }catch (IOException e){
            Log.e("Networking",e.getLocalizedMessage());
            return "";
        }
        return str;
    }
    private class GetServerResponse extends AsyncTask<PostComponent,Void,String>{
       protected String doInBackground(PostComponent... postComponents){
           return getTextInfo(postComponents[0]);
       }
        @Override
        protected void onPostExecute(String result) {
           TextView tv = (TextView)findViewById(R.id.tv);
            if(tv!=null){
                tv.setText(result);
           }
        }
    }
    private class PostComponent{
        String URL;
        JSONObject param;
        PostComponent(String URL, JSONObject param){
            this.URL=URL;
            this.param=param;
        }
        public String getURL(){
            return  URL;
        }
        public JSONObject getParam(){
            return param;
        }
    }
    public String getPostDataString(JSONObject params) throws Exception{
        StringBuilder result = new StringBuilder();
        boolean first = true;
        Iterator<String> itr = params.keys();
        while (itr.hasNext()){
            String key = itr.next();
            Object value = params.get(key);
            if(first)
                first = false;
            else
                result.append("&");
            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(),"UTF-8"));
        }
        return result.toString();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = findViewById(R.id.tv);
        final EditText editText = findViewById(R.id.editText);
        final String URL = "http://192.168.43.64/Buoi_6/test.php";
        final JSONObject postParams = new JSONObject();
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 tv.setText(editText.getText().toString());
               //  String url2 = tv.getText().toString();
                 try{
                   postParams.put("mssv","B1609548");
                 }catch (JSONException e){
                     e.printStackTrace();
                 }
                 PostComponent postRequest = new PostComponent(URL , postParams);
                 new GetServerResponse().execute(postRequest);
             }
         });
    }
}

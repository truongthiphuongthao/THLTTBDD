package com.example.b17_socket_thao_b1609548;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {
    private Button mButtonLogin;
    private Button mButtonChat;
    private EditText edtContent;
    private ListView lvUser, lvChat;
    private ImageButton btnAdd, btnSend;
    private TextView mTVRequest;
    ArrayList<String> arrayUser, arrayChat;
    ArrayAdapter adapterUser, adapterChat;
    private final String URL_SERVER = "http://192.168.1.8:3000";
    private Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd      = findViewById(R.id.btn_login);
        btnSend     = findViewById(R.id.btnchat);
        edtContent  = findViewById(R.id.editTextContent);
        lvChat      = findViewById(R.id.listviewChat);
        lvUser      = findViewById(R.id.listviewUser);
        arrayUser   = new ArrayList<>();
        adapterUser = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayUser);
        lvUser.setAdapter(adapterUser);
        arrayChat   = new ArrayList<>();
        adapterChat = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayChat);
        lvChat.setAdapter(adapterChat);
        try {
            mSocket = IO.socket(URL_SERVER);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mSocket.connect();
        mSocket.on("server-send-data", onRetrieveResult);
        mSocket.on("server-send-user", onListUser);
        mSocket.on("server-send-chat", onListChat);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtContent.getText().toString().trim().length()>0){
                    mSocket.emit("client-register-user",edtContent.getText().toString());
                }
                }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtContent.getText().toString().trim().length() > 0) {
                    mSocket.emit("client-send-chat",edtContent.getText().toString());
                }
            }
        });
    }
    private Emitter.Listener onListChat = new Emitter.Listener() {
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try{
                        String noiDung = object.getString("chatComent");
                        arrayChat.add(noiDung);
                        adapterUser.notifyDataSetChanged();
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                });
            }
        };
    private Emitter.Listener onListUser = new Emitter.Listener() {
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try{
                        JSONArray array = object.getJSONArray("danhsach");
                        adapterUser.clear();
                        for (int i = 0; i < array.length(); i++) {
                            String username = array.getString(i);
                            adapterUser.add(username);
                        }
                        adapterUser.notifyDataSetChanged();
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    };
        private Emitter.Listener onRetrieveResult = new Emitter.Listener() {
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                    //    String ten = object.getString("noidung");
                        boolean exits = object.getBoolean("ketqua");
                        if(exits){
                            Toast.makeText(MainActivity.this, "Tài khoản này đã tôn tại!", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(MainActivity.this, "Đã đăng ký thành công", Toast.LENGTH_LONG).show();
                        }
                        //Toast.makeText(MainActivity.this, ten, Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
}

package com.example.b5_1_thao_b1609548;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
EditText textBox;
static final int READ_BLOCK_SIZE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox=(EditText)findViewById(R.id.txtText1);
    }
    public void onClickSave(View view){
        String str = textBox.getText().toString();
        try{
            FileOutputStream fOut = openFileOutput("textfile.txt",0);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.write(str);
            osw.flush();
            osw.close();
            Toast.makeText(getBaseContext(),"File saved successfully!",Toast.LENGTH_SHORT).show();
            textBox.setText(" ");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void onClickLoad(View view){
        try{
            FileInputStream fIn = openFileInput("textfile.txt");
            InputStreamReader isr = new InputStreamReader(fIn);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s =" ";
            int charRead;
            while((charRead=isr.read(inputBuffer))>0){
                String readString = String.copyValueOf(inputBuffer,0, charRead);
                s+=readString;
                inputBuffer = new char[READ_BLOCK_SIZE];
            }
            textBox.setText(s);
            Toast.makeText(getBaseContext(),"File loaded successfully!", Toast.LENGTH_SHORT).show();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}

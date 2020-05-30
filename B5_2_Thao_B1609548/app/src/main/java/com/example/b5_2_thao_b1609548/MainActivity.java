package com.example.b5_2_thao_b1609548;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
EditText textBox;
static final int READ_BLOCK_SIZE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox = (EditText)findViewById(R.id.txtText1);
    }
    public void onClickSave(View view){
        String str = textBox.getText().toString();
        try{
            File sdCard = Environment.getExternalStorageDirectory();
            File directory = new File(sdCard.getAbsolutePath()+ "/MyFiles");
            directory.mkdirs();
            File file = new File(directory,"textfile.txt");
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.write(str);
            osw.flush();
            osw.close();
            Toast.makeText(getBaseContext(),"File saved sucessfully!", Toast.LENGTH_SHORT).show();
            textBox.setText(" ");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void onClickLoad(View view){
        try{
            //Doc file luu tren SD
            File sdCard = Environment.getExternalStorageDirectory();
            File directory = new File(sdCard.getAbsolutePath()+"/MyFiles");
            File file = new File(directory,"textfile.txt");
           /* FileInputStream fIn = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fIn);*/
            FileInputStream fIn = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fIn);
            // Doc file luu tren bo nho trong
           /* FileInputStream fIn = openFileInput("textfile.txt");
            InputStreamReader isr = new InputStreamReader(fIn);*/
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s=" ";
            int charRead;
            while((charRead=isr.read(inputBuffer))>0){
                String readString = String.copyValueOf(inputBuffer,0, charRead);
                s+=readString;
                inputBuffer = new char[READ_BLOCK_SIZE];
            }
            // Dat lai edit text
            textBox.setText(s);
            Toast.makeText(getBaseContext(),"File loaded successfully!", Toast.LENGTH_SHORT).show();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

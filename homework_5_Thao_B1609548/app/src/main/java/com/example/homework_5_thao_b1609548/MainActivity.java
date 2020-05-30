package com.example.homework_5_thao_b1609548;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private int position=0;
    private MediaController mediaController;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView)findViewById(R.id.videoView);
        if(mediaController==null){
            mediaController=new MediaController(MainActivity.this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
        }
        try{
            int id =  this.getRawResIdByName("tom");
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
        }catch (Exception e){
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
    }
    public int getRawResIdByName(String resName){
        String pkgName = this.getPackageName();
        int resID = this.getResources().getIdentifier(resName,"raw",pkgName);
        Log.i("AndoidVideoView","Res Name:"+resName+"==>ResID = "+resID);
        return resID;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("CurrentPosition",videoView.getCurrentPosition());
        videoView.pause();
    }
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("CurrentPosition");
        videoView.seekTo(position);
    }
}


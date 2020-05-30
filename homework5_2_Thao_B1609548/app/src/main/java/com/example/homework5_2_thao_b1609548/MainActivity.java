package com.example.homework5_2_thao_b1609548;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=(VideoView)findViewById(R.id.videoView);
        if(mediaController==null){
            mediaController=new MediaController(MainActivity.this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
        }
        try{
            String videoUrl ="https://r1---sn-8qj-8j5e7.googlevideo.com/videoplayback?expire=1590835758&ei=zuXRXvO1BsX8Dd3Cq9AG&ip=199.116.115.134&id=o-AG_vX19CqUbxmtpajlpHbHPY-wAc90s6LjTmRuC-mf-f&itag=18&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&gir=yes&clen=7473370&ratebypass=yes&dur=115.240&lmt=1431201668314045&fvip=1&fexp=23882514&c=WEB&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRgIhANH5ZcSS1rNND1iXzZXZybGnDTLhmbAiHzZA1MMv8LWSAiEAgGW5ItvtRqd0_XYSJSevHzhCDCpD6GumgletmYBcgds%3D&video_id=Pax6gzxbnxE&title=Tom+and+Jerry-+The+Movie+-+Trailer&redirect_counter=1&rm=sn-tt1le7e&req_id=b93110ecd8ba3ee&cms_redirect=yes&ipbypass=yes&mh=r7&mip=14.241.182.118&mm=31&mn=sn-8qj-8j5e7&ms=au&mt=1590814056&mv=m&mvi=0&pl=24&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIhAMGZD45Mod5UOLSFPXFsmt3eaMj9ojSaxAwfLU8MnnqTAiAaNkIdFKx8JPojKHeqnM1pi_EnHq30-Yv2rU-rtDMuhQ%3D%3D";
            Uri video = Uri.parse(videoUrl);
            videoView.setVideoURI(video);
        }catch (Exception e){
            Log.e("Error",e.getMessage());
            e.printStackTrace();
        }
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(final MediaPlayer mediaPlayer) {
                videoView.seekTo(position);
                if(position==0){
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

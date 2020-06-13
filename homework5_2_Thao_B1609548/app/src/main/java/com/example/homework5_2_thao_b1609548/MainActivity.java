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
            String videoUrl ="https://r6---sn-8qj-nboey.googlevideo.com/videoplayback?expire=1592031797&ei=1SXkXuHsBsXigAeok4roCw&ip=87.120.253.132&id=o-AIVI-ZQTt0UG5br3iRHSWxcxbKCHMDCtEj9gEKwEO18w&itag=18&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&gir=yes&clen=13206923&ratebypass=yes&dur=233.941&lmt=1574712496435710&fvip=2&fexp=23812955,23882513&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgMYJ3unp2Xz-11U4yG8wYL-0-FWmK-G-Hnciz52L9krACIBYKW8H4vOGJL9u6e_I8rS81lToJ0DzC0_b6IdXzmHA9&video_id=6Q0Pd53mojY&title=%E5%91%A8%E6%9D%B0%E5%80%AB+Jay+Chou%E3%80%90%E5%A4%9C%E6%9B%B2+Nocturne%E3%80%91Official+Music+Video&redirect_counter=1&rm=sn-4g5ezs7l&req_id=54ec581c140ea3ee&cms_redirect=yes&ipbypass=yes&mh=OF&mip=113.185.82.112&mm=31&mn=sn-8qj-nboey&ms=au&mt=1592010094&mv=m&mvi=5&pcm2cms=yes&pl=24&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pcm2cms,pl&lsig=AG3C_xAwRAIgOcbyjTkxfO9HmF6QmGoyFBDechyFfXZv9OnFtKS26_ICIFufJP5vuVZAfUQrunoH7Yy4Hno1PZDkIKtuVXWW_owk";
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

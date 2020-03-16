package com.example.buoi2_thao_b1609548;
import android.graphics.*;
import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.*;
public class ThreadView extends Thread {
    private GamePanel mpanel;
    private SurfaceHolder mholder;
    private boolean mrun=false;

    public ThreadView(GamePanel panel){
        mpanel = panel;
        mholder = mpanel.getHolder();
    }
    public void setRunning(boolean run){
        mrun=run;
    }
    public void run(){
        Canvas canvas=null;
        while (mrun){
            canvas=mholder.lockCanvas();
            if(canvas!=null){
                mpanel.doDraw(canvas);
                mholder.unlockCanvasAndPost(canvas);
            }
        }
    }
}

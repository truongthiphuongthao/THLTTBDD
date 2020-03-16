package com.example.buoi2_thao_b1609548;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.sql.Time;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    Bitmap bitmap;
    int count = 20;
    Time time = new Time();
    ThreadView thread;
    int dia;
    int kq = 0;
    int x, y;
    int X;
    int Y;
    Bug bug;
    float dis;

    public GamePanel(Context context) {
        super(context);
        bug = new Bug(context);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bug);
        dia = bitmap.getWidth();
        getHolder().addCallback(this);
        thread = new ThreadView(this);
        time.start();
    }

    public void doDraw(Canvas c) {
        if (count > 0) {
            bug.onDraw(c);
            Paint tpaint = new Paint();
            tpaint.setColor(Color.BLACK);
            c.drawText("Time" + count, 10, 10, tpaint);
        } else if (count <= 0) {
            if (kq >= 5) {
                Paint spaint = new Paint();
                spaint.setColor(Color.BLACK);
                c.drawPaint(spaint);
                spaint.setColor(Color.WHITE);
                spaint.setTextSize(30);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("YOU WIN!", c.getWidth() / 2, c.getHeight() / 2 - 60, spaint);
                c.drawText("Record" + kq, c.getWidth() / 2, c.getHeight() / 2, spaint);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("touch to quit", c.getWidth() / 2, c.getHeight() / 2 + 60, spaint);
            } else if (kq < 5) {
                Paint spaint = new Paint();
                spaint.setColor(Color.BLACK);
                c.drawPaint(spaint);
                spaint.setColor(Color.WHITE);
                spaint.setTextSize(30);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("YOU LOSE!", c.getWidth() / 2, c.getHeight() / 2 - 60, spaint);
                c.drawText("Record" + kq, c.getWidth() / 2, c.getHeight() / 2, spaint);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("touch to quit", c.getWidth() / 2, c.getHeight() / 2 + 60, spaint);
            }
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // todo
    }

    public void surfaceCreated(SurfaceHolder holder) {
        if (!thread.isAlive()) {
            thread = new ThreadView(this);
            thread.setRunning(true);
            thread.start();
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        if (thread.isAlive()) {
            thread.setRunning(false);
        }
    }

    public class Time extends Thread {
        public void run() {
            while (count > 0) {
                try {
                    count--;
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        X = (int) event.getX();
        Y = (int) event.getY();
        switch (eventaction) {
            case MotionEvent.ACTION_DOWN: {
                int centerX = bug.x + dia;
                int centerY = bug.y + dia;
                dis = (float) Math.sqrt((((centerX - X) * (centerX - X)) + (centerY - Y) * (centerY - Y)));
                if (count < 0) {
                    if (dis < dia) {
                        kq++;
                        bug.x = 100;
                        bug.y = 100;
                    }
                }
                if (count <= 0) {
                    System.exit(0);
                }
            }
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}

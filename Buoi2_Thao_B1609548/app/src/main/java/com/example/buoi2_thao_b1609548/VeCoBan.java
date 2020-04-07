package com.example.buoi2_thao_b1609548;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class VeCoBan extends View {
    private final Paint paint = new Paint();
    public VeCoBan(Context context){super(context);}
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        // Lấy chiều ngang của màn hình
        int xcanvas=canvas.getWidth();
        // Lấy chiều dọc của màn hình
        int ycanvas=canvas.getHeight();
        // Cho canvas màu trắng
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        // Vẽ test "LẬP TRÌNH GIAO DIỆN MỨC THẤP"
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(60);
        canvas.drawText("LẬP TRÌNH GIAO DIỆN MỨC THẤP",60,60,paint);

        // Hiển thị kích thước màn hình
        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        String Wcanvas=Integer.toString(xcanvas);
        canvas.drawText("Chiều rộng của màn hình = "+Wcanvas,80,140,paint);
        String Hcanvas = Integer.toString(ycanvas);
        canvas.drawText("Chiều cao của màn hình = "+Hcanvas,80,220,paint);

        // Khai báo một hình chữ nhật để vẽ cung trong đó
        RectF rectF = new RectF(10, ycanvas/4-xcanvas/8+50, xcanvas/2+10,ycanvas/4+xcanvas/2-70);
        paint.setColor(Color.WHITE);
        // Hình oval nằm trong HCN chứa cung sắp vẽ
        canvas.drawOval(rectF,paint);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        // Vẽ cung
        canvas.drawArc(rectF,-135,90,true,paint);

        // Vẽ circle
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(xcanvas/2+100, ycanvas/4+40, xcanvas/8-10, paint);
        //Vẽ line
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawLine(xcanvas/2+xcanvas/4, xcanvas/4, xcanvas-60, ycanvas/4+xcanvas/8,paint);
        // Vẽ hình chữ nhật đầy màu
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(20, ycanvas/4+250, canvas.getWidth()-20, canvas.getHeight()-80,paint);
        // Vẽ rotated text "Seahorse"
        paint.setColor(Color.RED);
        // Quay canvas -45 đo
        canvas.rotate(-45, xcanvas/4, ycanvas/4+450);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(100);
        canvas.drawText("Seahorse",xcanvas/4, 3*ycanvas/4+200,paint);
        // canvas restore()
        // Quay canvas trở lại ( thay hàm restore)
        canvas.rotate(45, xcanvas/2,ycanvas/4+450);

        // Vẽ image
        Resources res = this.getResources();
        Bitmap bit = BitmapFactory.decodeResource(res, R.drawable.seahorse);
        float d=bit.getWidth();
        float xstar=xcanvas/8;
        float ystar=3*ycanvas/4;
        RectF rectF2 = new RectF(xstar,ystar, xstar+d, ystar+d);
        canvas.drawBitmap(bit,null,rectF2,paint);
    }

}

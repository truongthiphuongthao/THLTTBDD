package com.example.buoi2_thao_b1609548;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class ChuyenDong extends View {
    // Tốc độ chuyển động
    private float ballSpeedX = 4;
    private float ballSpeedY = 7;
    // Tọa độ ban đầu
    private float x = 10;
    private float y = 10;
    // Đường kính
    Paint paint = new Paint();
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.network);
    private float diameter;
  public ChuyenDong (Context context){
      super(context);
  }
  protected void onDraw(Canvas canvas){
      canvas.drawPaint(paint);
      canvas.drawBitmap(bitmap, x, y, paint);
      diameter = bitmap.getWidth();
      update();
      // Buộc vẽ lại
      invalidate();
  }
  private void update(){
      // Lấy tọa độ mới (x,y) để vẽ quả địa cầu chuyển động ngẫu nhiên
      x += ballSpeedX;
      y += ballSpeedY;
      // Nếu chạm biên thì đổi ảnh và đổi chiều chuyển động
      if (x<=0 || (x>=getWidth()-diameter)){
          ballSpeedX = -ballSpeedX;
          bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.network);
      }
      if(y<=0||y>=getHeight()-diameter){
          ballSpeedY = -ballSpeedY;
          bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.internet);
      }
  }
}

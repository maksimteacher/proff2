package org.start;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CanvasActivity3 extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new DrawView(this));
  }

  class DrawView extends SurfaceView implements SurfaceHolder.Callback {

    private DrawThread drawThread;

    public DrawView(Context context) {
      super(context);
      getHolder().addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
        int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
      drawThread = new DrawThread(getHolder());
      drawThread.setRunning(true);
      drawThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
      boolean retry = true;
      drawThread.setRunning(false);
      while (retry) {
        try {
          drawThread.join();
          retry = false;
        } catch (InterruptedException e) {
        }
      }
    }

    class DrawThread extends Thread {

      private boolean running = false;
      private SurfaceHolder surfaceHolder;

      public DrawThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
      }

      public void setRunning(boolean running) {
        this.running = running;
      }

      @Override
      public void run() {
        Canvas canvas;
        Paint paint = new Paint();
        paint.setColor(Color.MAGENTA);
		paint.setStrokeWidth(8);
		int xPos = 100;
		int deltaX = 1;
        while (running) {
          canvas = null;
          if(xPos >800)xPos = 1;
          xPos += deltaX;
          try {
            canvas = surfaceHolder.lockCanvas(null);
            if (canvas == null)
              continue;
            canvas.drawColor(Color.GREEN);
            canvas.drawPoint(xPos,200, paint);
          } finally {
            if (canvas != null) {
              surfaceHolder.unlockCanvasAndPost(canvas);
            }
          }
        }
      }
    }

  }

}
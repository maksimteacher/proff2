package org.start;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class CanvasActivity_SurfaceView extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawView(this));
	}

	class DrawView extends View {

		public DrawView(Context context) {
			super(context);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawColor(Color.GREEN);
			new DrawThread(canvas).start();
		}

		class DrawThread extends Thread {
			Canvas canvas;
			private int xPos = 1;
			private int xDelta = 1;
			private int yPos = 1;
			private Paint pointPaint = new Paint(Color.GREEN);
			private Paint emptyPaint = new Paint(Color.WHITE);
			
			public DrawThread(Canvas canvas) {
				this.canvas = canvas;
				pointPaint.setStrokeWidth(10);
				emptyPaint.setStrokeWidth(10);
			}

			public void run() {
				while (true) {
					canvas.drawPoint(xPos, yPos, emptyPaint);
					xPos += xDelta;
					canvas.drawPoint(xPos, yPos, pointPaint);
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					invalidate();
				}
			}
		}
	}
}
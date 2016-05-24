package org.start;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class CanvasActivity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawView(this));
	}

	class DrawView extends View {

		Paint paint;
		Rect rect;

		public DrawView(Context context) {
			super(context);
			paint = new Paint();
			rect = new Rect();
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// fill canvas color
			//canvas.drawARGB(80, 102, 204, 255);
			canvas.drawARGB(80, 201, 100, 200);

			// set color and width
			paint.setColor(Color.MAGENTA);
			paint.setStrokeWidth(8);


			// point (10,10)
			canvas.drawPoint(10, 10, paint);

			// rectangle, point up-left(200,150), point down-right (400,200)
			canvas.drawRect(100, 550, 400, 200, paint);

			// change color
			paint.setColor(Color.BLUE);
			
			//circle (800,200), raduis = 40
			canvas.drawCircle(800, 200, 40, paint);
			
			
			// rectangle, point up-left(250,300), point down-right (350,500)
			rect.set(250, 300, 350, 500);
			canvas.drawRect(rect, paint);
			
			// line from (120,600) to (400,550)
			canvas.drawLine(120, 600, 400, 550, paint);
			
			paint.setColor(Color.RED);
			float[] points = new float[]{100,50,150,100,150,200,50,200,50,100};
			canvas.drawPoints(points,paint);
			
			paint.setColor(Color.YELLOW);
			float[] points1 = new float[]{200,100,300,200,300,100,400,200};
			canvas.drawLines(points1,paint);
		}

	}

}
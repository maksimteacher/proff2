package org.start;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class CanvasActivity3 extends Activity {

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
			canvas.drawARGB(80, 102, 204, 255);

			// set color and width
			paint.setColor(Color.RED);
			paint.setStrokeWidth(10);


			// point (50,50)
			canvas.drawPoint(50, 50, paint);

			// line from (100,100) to (500,50)
			canvas.drawLine(100, 100, 500, 50, paint);

			// circle (100,200), raduis = 50
			canvas.drawCircle(100, 200, 50, paint);

			// rectangle, point up-left(200,150), point down-right (400,200)
			canvas.drawRect(200, 150, 400, 200, paint);

			// rectangle, point up-left(250,300), point down-right (350,500)
			rect.set(250, 300, 350, 500);
			canvas.drawRect(rect, paint);
			
			paint.setColor(Color.RED);
			float[] points = new float[]{100,50,150,100,150,200,50,200,50,100};
			canvas.drawPoints(points,paint);
			
			//invalidate();
		}

	}

}
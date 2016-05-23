package proff2_example_androiddesign;

import com.example.proff2_example_androiddesign.R;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.EditText;

public class MainActivity extends Activity{
	EditText text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_layout);
		
		text = (EditText) findViewById(R.id.editText1);
		
		StringBuilder sb = new StringBuilder();
		
		DisplayMetrics metrika = this.getResources().getDisplayMetrics();
        sb.append("heightPixels="+metrika.heightPixels);
        sb.append(",\n widthPixels="+metrika.widthPixels);

		
		Configuration config = this.getResources().getConfiguration();
        sb.append(",\n screenWidthDp="+config.screenWidthDp);
        sb.append(",\n screenHeightDp="+config.screenHeightDp);

		text.setText(sb.toString());
	}
}

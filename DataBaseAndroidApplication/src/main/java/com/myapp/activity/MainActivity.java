package main.java.com.myapp.activity;


import org.proff2.example.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_layout);
		layout = (LinearLayout) findViewById(R.id.mainLayuotMyId);
		
		Log.i("myMain", "MainActivity created");
		
		((Button) findViewById(R.id.buttonToBDExmple)).setOnClickListener(this);
		((Button) findViewById(R.id.buttonToSpisok)).setOnClickListener(this);		
	}
		
	public void onClick(View view) {
		Intent intent = null;
		if(view.getId() == R.id.buttonToBDExmple) intent = new Intent(this, DBExampleActivity.class);
		if(view.getId() == R.id.buttonToSpisok) intent = new Intent(this, ListActivity.class);
		
		if(intent!=null)startActivity(intent);
		
		
	}
	LinearLayout layout;
	public void addButton(View view){
		Button newBtn = new Button(this);
		newBtn.setText("My New Button");
		layout.addView(newBtn);
	}
	
}

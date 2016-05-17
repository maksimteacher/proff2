package org.start;

import com.example.myfirstandroidapplication.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity{
	private EditText text;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		text = (EditText) findViewById(R.id.text1);
		btn = (Button) findViewById(R.id.button2);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "text", Toast.LENGTH_SHORT).show();
			}
		});
	}
	public void myClick(View view){
		text.setText("My message");
	}
	public void myClickRedirect(View view){
		Intent intent = new Intent(this, NextActivity.class);
		intent.putExtra("par1", "value of par1");
		startActivity(intent);
	}
}

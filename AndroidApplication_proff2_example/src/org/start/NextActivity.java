package org.start;

import com.example.myfirstandroidapplication.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class NextActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next_layout);
		
		Intent intent = getIntent();
		String str = intent.getStringExtra("par1");
		
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}	
}

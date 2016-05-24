package org.start;

import com.example.proff2_example_game1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.GridLayout.Spec;

public class MainActivity  extends Activity{
	private GridLayout gridLayout;
	private Button[][] btns;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		gridLayout = (GridLayout) findViewById(R.id.GridLayout1);
		
		initButtons();
		addButtonsToGridLayout();
	}
	private int countLine = 3;
	private int countRow = 3;
	
	public void initButtons(){
		btns = new Button[countLine][countRow];
		for(int i = 0; i<btns.length; i++){
			for(int j = 0; j<btns[i].length; j++){
				btns[i][j] = new Button(this);
				btns[i][j].setText(i+""+j);
			}			
		}
	}
	public void addButtonsToGridLayout(){
		gridLayout.setColumnCount(countLine);
		gridLayout.setRowCount(countRow);
		for(int i = 0; i<btns.length; i++){
			for(int j = 0; j<btns[i].length; j++){
				LayoutParams params = new LayoutParams(GridLayout.spec(i), GridLayout.spec(j));
				gridLayout.addView(btns[i][j], params);
				btns[i][j].setWidth(200);
				btns[i][j].setHeight(100);
			}			
		}		
	}
	public void redirectToCanvasActivity2(View view){
		Intent intent = new Intent(this,CanvasActivity2.class);
		startActivity(intent);
	}
	public void redirectToCanvasActivity3(View view){
		Intent intent = new Intent(this,CanvasActivity3.class);
		startActivity(intent);
	}
}

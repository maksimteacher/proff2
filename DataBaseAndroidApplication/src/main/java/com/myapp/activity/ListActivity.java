package main.java.com.myapp.activity;

import java.util.ArrayList;
import java.util.List;

import org.proff2.example.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);
		
		spisok = (ListView) findViewById(R.id.listView1);
		
		List<String> items = initData();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		
		spisok.setAdapter(adapter);
	}
	ListView spisok;
	
	private List<String> initData(){
		List<String> list = new ArrayList();
		list.add("Черная машина");
		list.add("Красный автомобиль");
		list.add("Синий кадилак");
		return list;
	}
}

package main.java.com.myapp.activity;

import org.proff2.example.R;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import main.java.com.myapp.util.DBHelper;

public class DBExampleActivity extends Activity {
	DBHelper dbHelper;
	public final static String TAG = "myMain";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_layout);

		dbHelper = new DBHelper(this);
	}

	// SQLiteDatabase: query(), insert(), delete(), update(), execSQL().
	public void onClickBtnAdd(View view) {
		Log.i(TAG, "сработало событие onClickBtnAdd");
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		try {
			for (int i = 0; i < 4; i++) {
				ContentValues contentValues = new ContentValues();

				contentValues.put(DBHelper.FIELD_NUMBER, "AA " + i + i + i + i);
				contentValues.put(DBHelper.FIELD_COLOR, "Black");

				database.insert(DBHelper.TABLE_CARS, null, contentValues);
			}
			Log.d(TAG, "добавление успешно");
		} catch (Exception e) {
			Log.d(TAG, "ошибка добавления");
		} finally {
			database.close();
		}

	}

	public void onClickBtnRead(View view){
		Log.d(TAG, "сработало событие onClickBtnRead");
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		Cursor cursor = database.query(DBHelper.TABLE_CARS,null,null,null,null,null,null);
		if(cursor.moveToFirst()){
			int f1Index = cursor.getColumnIndex(DBHelper.FIELD_ID);
			int f2Index = cursor.getColumnIndex(DBHelper.FIELD_NUMBER);
			int f3Index = cursor.getColumnIndex(DBHelper.FIELD_COLOR);
			
			do{
				Log.i(TAG,"id="+cursor.getInt(f1Index)
					+",name"+cursor.getString(f2Index)
					+",mail="+cursor.getString(f3Index));
			} while(cursor.moveToNext());
		
		} else Log.d(TAG, "нет данных");
		cursor.close();		
	}
}

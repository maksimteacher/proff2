package main.java.com.myapp.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "myDB";
	public static final String TABLE_CARS = "car";
	
	public static final String FIELD_ID = "id";
	public static final String FIELD_NUMBER = "number";
	public static final String FIELD_COLOR = "color";
	
	public DBHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL("create table " + TABLE_CARS + "(" + FIELD_ID
			+ " integer primary key," + FIELD_NUMBER + " text,"+FIELD_COLOR + " text"			
			+ ")");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists " + TABLE_CARS);
		
		onCreate(db);
	}
}

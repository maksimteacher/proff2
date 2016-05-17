package main.java.domain;

public class Car {
	private int id;
	private String number;
	private String color;
	private String marka;
	
	public final static String[] TABLE_FIELDS = new String[]{"id","number","color","marka"};
	
	public Car(String number, String color, String marka) {
		this.number = number;
		this.color = color;
		this.marka = marka;
	}
	public Car() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	
}

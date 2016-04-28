package builderCars;

public class Car {
	String number;
	String color;
	String marka;
	
	public Car(){};
	
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
	@Override
	public String toString() {
		return "Car [number=" + number + ", color=" + color + ", marka=" + marka + "]";
	}
	

}

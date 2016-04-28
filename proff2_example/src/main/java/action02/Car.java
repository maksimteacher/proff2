package action02;

public class Car implements Comparable<Car>{
	private String number;
	private String color;
	
	
	
	@Override
	public int hashCode() {
		int codeNumber = 0;
		if(number!= null) codeNumber = number.hashCode();
		int codeColor = 0;
		if(color!= null) codeColor = color.hashCode();
		return codeNumber * 32 + codeColor;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Car car = (Car)obj;
		
		String separator = "_*_";
		String thisStr = number + separator + color;
		String carStr = car.number + separator + car.color;

		return thisStr.equals(carStr);
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
	public Car(String number, String color) {
		super();
		this.number = number;
		this.color = color;
	}
	@Override
	public int compareTo(Car car) {
		if(car == null) return -1;

		String separator = "_*_";
		String thisStr = number + separator + color;
		String carStr = car.number + separator + car.color;
		
		return thisStr.compareTo(carStr);
	}
	@Override
	public String toString() {
		return "Car [number=" + number + ", color=" + color + "]";
	}
	
	
}

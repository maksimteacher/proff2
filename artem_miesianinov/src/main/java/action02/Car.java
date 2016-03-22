package action02;

public class Car {
	private String number;
	private String color;
	
	@Override
	public int hashCode(){
		int codeNumber = 0;
		if(number!= null) codeNumber = number.hashCode();
		int codeColor = 0;
		if(color!= null) codeColor = color.hashCode();
		return codeNumber*32 + codeColor;
	}
	
	public boolean equals(Car car) {	
		if (this == car) return true;
		if (car == null) return false;
		if (getClass() != car.getClass()) return false;
		
		String separator = "&&";
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
	
	

}

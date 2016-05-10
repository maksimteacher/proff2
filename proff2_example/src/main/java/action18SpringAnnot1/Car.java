package action18SpringAnnot1;

import org.springframework.stereotype.Component;

@Component("Car")
public class Car {
	private String number;
	private String color="Red";

	public Car() {
	}
	public Car(String number, String color) {
		this.number = number;
		this.color = color;
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
	@Override
	public String toString() {
		return "Car [number=" + number + ", color=" + color + "]";
	}
}

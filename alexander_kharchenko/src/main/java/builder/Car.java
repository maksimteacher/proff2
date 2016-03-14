package builder;

public class Car {
	private String color;
	private String number;
	private String makrka;
	
	public Car () {
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMakrka() {
		return makrka;
	}

	public void setMakrka(String makrka) {
		this.makrka = makrka;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", number=" + number + ", makrka=" + makrka + "]";
	}
	
}

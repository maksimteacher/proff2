package builder;

public class CarBuilder {
	private Car car;
	
	public CarBuilder(){
		car = new Car();
	}
	
	public Car build() {
		System.out.println("111");
		return car;
	}
	


	public CarBuilder setColor(String color) {
		car.setColor(color);
		return this;
	}


	public CarBuilder setNumber(String number) {
		car.setNumber(number);
		return this;
	}


	public CarBuilder setMakrka(String makrka) {
		car.setMakrka(makrka);
		return this;
	}
	
	
}

package builderCars;
/*Задача 2. Builder. Создать класс автомобиль с полями: color, number, marka.
 Реализовать класс BuilderCar, чтобы можно было создать автомобиль таким образом:
 Car car1 = new BuilderCar().setNumber("AA 1111").build();
 Car car2 = new BuilderCar().setNumber("BB 2222").setColor("Red").build();
 Car car3 = new BuilderCar().setNumber("CC 33333").setMarka("BMW").setColor("Red").build();*/

public class BuilderCar {
	private Car car;

	public BuilderCar() {
		car = new Car();
	}

	public Car build() {
		System.out.println("111");
		return car;
	}

	
	public BuilderCar setColor(String color) {
		car.setColor(color);
		return this;
	}


	public BuilderCar setNumber(String number) {
		car.setNumber(number);
		return this;
	}


	public BuilderCar setMakrka(String marka) {
		car.setMarka(marka);
		return this;
	}
	
	
	

}

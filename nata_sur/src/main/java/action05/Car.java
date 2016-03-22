package action05;

/*Задача 2. Builder. Создать класс автомобиль с полями: color, number, marka.
Реализовать класс BuilderCar, чтобы можно было создать автомобиль таким образом:
Car car1 = new BuilderCar().setNumber("AA 1111").build();
Car car2 = new BuilderCar().setNumber("BB 2222").setColor("Red").build();
Car car3 = new BuilderCar().setNumber("CC 33333").setMarka("BMW").setColor("Red").build();*/

public class Car {
	private String colour;
	private String number;
	private String marka;

	public Car(BuilderCar builder) {
		this.colour = builder.getColour();
		this.number = builder.getNumber();
		this.marka = builder.getMarka();
	}

	@Override
	public String toString() {
		return "Car [colour=" + colour + ", number=" + number + ", marka=" + marka + "]";
	}

	static class BuilderCar {
		private String colour;
		private String number;
		private String marka;

		private BuilderCar() {

		}

		public String getColour() {
			return colour;
		}

		public BuilderCar setColour(String colour) {
			this.colour = colour;
			return this;
		}

		public String getNumber() {
			return number;
		}

		public BuilderCar setNumber(String number) {
			this.number = number;
			return this;
		}

		public String getMarka() {
			return marka;
		}

		public BuilderCar setMarka(String marka) {
			this.marka = marka;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}

	public static void main(String[] args) {
		Car car = new BuilderCar().setNumber("AA 1111").setColour("Red").setMarka("Audi").build();
		System.out.println(car);
	}
}
package action05;

public class TestCar {

	public static void main(String[] args) {

		Car car = Car.BuilderCar()
				.setColor("Red")
				.setNumber("DP 001")
				.setMarka("BMV")
				.build();

		System.out.println(car);

	}

}

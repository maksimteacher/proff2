package builderCars;

public class Runner {
	
	public static void main(String[] args) {
		Car c = new BuilderCar().setNumber("AA 1111").build();
		System.out.println(c);
	}

}

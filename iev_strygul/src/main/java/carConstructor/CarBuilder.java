package carConstructor;

public class CarBuilder {
	private Car car;
	
	public CarBuilder() {
		car = new Car();
	}
	
	public CarBuilder setEngine(Engine engine) {
		car.setEngine(engine);
		getInfo();
		return this;
	}
	
	public CarBuilder setComputer(Computer computer) {
		car.setComputer(computer);
		getInfo();
		return this;
	}
	
	public CarBuilder setFrame(Frame frame) {
		car.setFrame(frame);
		getInfo();
		return this;
	}
	
	public Car build() {
		return car;
	}
	
	public void getInfo() {
		System.out.println("Car characteristics:");
		System.out.println("Computer: " + car.getComputer());
		System.out.println("Engine: " + car.getEngine());
		System.out.println("Frame: " + car.getFrame());
		System.out.println();
	}
}

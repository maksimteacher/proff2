package Car;
public class CarConstructor{
	
	private Car car;
	public CarConstructor(){
		car = new Car();
	}
	
	public CarConstructor Engine(Engine engine){
		car.setEngine(engine);
		System.out.println("Engine: " + car.getEngine());
		return this;
			
	}
	
	public CarConstructor Computer(Computer computer){
		car.setComputer(computer);
		System.out.println("Computer"+car.getComputer());
		return this;
	}
	public CarConstructor Body(Body body){
		car.setBody(body);
		System.out.println("Body"+car.getBody());
		return this;
	}
	public Car Constructor(){
		return car;
	}
}
package builder.objects;

import builder.objects.body.Body;
import builder.objects.computer.Computer;
import builder.objects.engine.Engine;

public class CarBuilder {
	private Engine engine;
	private Computer computer;
	private Body body;
	
	public CarBuilder() {
		
	}
	
	public Car build() {
		return new Car(engine, computer, body);
	}

	public CarBuilder setEngine(Engine engine) {
		this.engine = engine;
		System.out.println("engine " + engine + " was added.");
		return this;
	}

	public CarBuilder setComputer(Computer computer) {
		this.computer = computer;
		System.out.println("computer " + computer + " was added.");
		return this;
	}

	public CarBuilder setBody(Body body) {
		this.body = body;
		System.out.println("body " + body + " was added.");
		return this;
	}
	
	
}

package builder.objects;

import builder.objects.body.Body;
import builder.objects.computer.Computer;
import builder.objects.engine.Engine;

public class Car {
	private Engine engine;
	private Computer computer;
	private Body body;
	
	public Car() {
		
	}
	
	public Car(Engine engine, Computer computer, Body body) {
		this.engine = engine;
		this.computer = computer;
		this.body = body;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Car [engine=" + engine + ", computer=" + computer + ", body=" + body + "]";
	}
	
	
}

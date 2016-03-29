package action05;

public class BuilderCarHW {
	
	private String engine;
	private String computer;
	private String body;
	
	public static void main(String[] args) {
		Car car1 = new BuilderCarHW().setEngine("EngineVolvo").setBody("bodyToyota").setComputer("ComputerInfinity").build();
		System.out.println(car1);
	}
	
	public Car build() {
		return new Car(this);
	}
	
	public BuilderCarHW setEngine(String engine) {
		this.engine = engine;
		return this;
	}
	
	public String getEngine() { 
		return engine;
	}
	
	
	public BuilderCarHW setBody(String body) {
		this.body = body;
		return this;
	}
	
	public String getBody() {
		return body;
	}
	
	public BuilderCarHW setComputer(String computer) {
		this.computer = computer;
		return this;
	}
	
	public String getComputer() {
		 return computer;
	}

  class Car{
	private String engine;
	private String computer;
	private String body;
	
	public Car (BuilderCarHW builder) {
		this.engine = builder.getEngine();
		this.body = builder.getBody();
		this.computer = builder.getComputer();
	}
	
	@Override
	
	public String toString() {
		return "Car [ " + engine + ", " + body + ", " + computer + "]";
		
	
	}
	}
}



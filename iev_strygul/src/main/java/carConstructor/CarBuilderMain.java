package carConstructor;

class CarBuilderMain {

	public static void main(String[] args) {
		
		Car car = new CarBuilder().setEngine(Engine.EngineExplorer).setComputer(Computer.ComputerStrongler).build();
	}

}

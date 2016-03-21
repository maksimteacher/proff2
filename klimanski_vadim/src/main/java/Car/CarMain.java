package Car;

public class CarMain {
public static void main(String[] args) {
	Car car = new CarConstructor().Engine(Engine.EngineSpensor).Computer(Computer.ComputerInfini).Body(Body.bodyAsyasya).Constructor();
	System.out.println(car);
}
}

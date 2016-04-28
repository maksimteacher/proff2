package builder.objects;

import builder.objects.body.BodyToyota;
import builder.objects.computer.ComputerAsyasya;
import builder.objects.engine.EngineExplorer;

public class Runner {

	public static void main(String[] args) {
		Car c1 = new CarBuilder()
				.setBody(new BodyToyota())
				.setEngine(new EngineExplorer())
				.setComputer(new ComputerAsyasya())
				.build();
		System.out.println(c1);
	}

}

package builder;

public class Runner {

	public static void main(String[] args) {
		Car c = new CarBuilder().setNumber("AA 1111").build();
		System.out.println(c);
	}

}

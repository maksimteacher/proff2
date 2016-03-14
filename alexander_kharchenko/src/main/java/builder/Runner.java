package builder;

public class Runner {

	public static void main(String[] args) {
		Car c = new CarBuilder().setNumber("AA 1111").build();
		System.out.println(c);
		Car c1 = new CarBuilder().setColor("Red").setMakrka("Honda").build();
		System.out.println(c1);
	}

}

package action05;

public class Test01 {

	public static void main(String[] args) {
		Server s = Server.Sv;
		System.out.println(s.getColor());
		s.setColor("Blue");
		System.out.println(s);

		Server s2 = Server.Sv;
		System.out.println(s2);		
		System.out.println(s2.getColor());
	}

}

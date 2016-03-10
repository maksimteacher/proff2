package singlton;

public class Runner {
	public static void main(String[] args) {
		Server s1 = Server.getInstance();
		
		Server s2 = Server.getInstance();
		
		System.out.println(s1 == s2);
		
	}
}

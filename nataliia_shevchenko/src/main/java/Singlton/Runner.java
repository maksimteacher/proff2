package Singlton;

public class Runner {
	//public static void main(String[] args) {
//		Server s1 = new Server();
//		Server s2 = new Server();
//		if(s1 != s2) System.out.println("This is not SERVER!!");
//	}
		public static void main(String[] args) {
			Server s1 = Server.getInstance();
			Server s2 = Server.getInstance();
			
			System.out.println(s1 == s2);
			
		}
	

}

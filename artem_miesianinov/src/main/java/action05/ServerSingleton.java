package action05;

public class ServerSingleton {

	private static ServerSingleton Instance = new ServerSingleton();
	
	private ServerSingleton() {}
	
	public static ServerSingleton getInstance() {
		return Instance;//
	}
 	public static void main(String[] args) {
 		
	}

}

package action05;

public final class Server {

	private static Server obj;
	
	private Server() {
	}
	
	public static Server getInstance(){
		if (obj == null) obj = new Server();
		return obj;
	}

}

package action05;

public class Server {
	private static Server server=null;
	private Server(){		
	}
	public static Server getInstance(){
		if(server == null){
			server = new Server();
		}
		return server;
	}	
}
class Server1{
	private static Server1 server = new Server1();
	private Server1(){		
	}
	public static Server1 getInstance(){
		return server;
	}
}


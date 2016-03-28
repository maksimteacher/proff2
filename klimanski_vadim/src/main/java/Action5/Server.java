package Action5;


public class Server{
	
	private static final Server inst = new Server();
	public Server(){	}
			public static Server getInst(){
				return inst;
			}
			
}



package Singlton;
//это называется ленивая реализация
public class Server {
	
	private static Server inst;

	private Server() {
		
	}

	public static Server getInstance(){
		if (inst == null){
			inst = new Server();
		}
		return inst;
	}

}


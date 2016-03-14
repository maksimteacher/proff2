package action05;

//Задание 1. Singleton. Создать класс Server, на основе шаблона синглтон. 

public class Server {
	private static Server server;

	Server() {
	}

	public static Server getServer() {
		if (server == null) {
			server = new Server();
		}
		return server;
	}

	public static void main(String[] args) {
		Server server1 = Server.getServer();
		Server server2 = Server.getServer();
		if (server1 != server2) {
			System.out.println("No singleton!!!");
		}
		System.out.println("Singleton=)");
	}
}
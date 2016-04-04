package sockets2;

public class Runner {

	public static void main(String[] args) {
		Server server = new Server();
		Client client = new Client(Server.port1);
		Client client2 = new Client(Server.port1);
		
		server.start();
		client.start();
		client2.start();
		

	}

}

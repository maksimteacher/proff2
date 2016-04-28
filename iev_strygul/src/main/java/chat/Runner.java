package chat;

public class Runner {
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
		Client client = new Client();
		client.start();
		Client client2 = new Client();
		client2.start();
	}
}

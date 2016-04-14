package sockets;

public class Runner {
	public static void main(String[] args) {
		ServerSocketExample server = new ServerSocketExample();
		SocketExample client = new SocketExample();
		
		server.start();
		client.start();
	}
}

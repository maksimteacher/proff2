package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	ServerSocket server;
	public static final int PORT = 4444;
	
	@Override
	public void run() {
		try {
			server = new ServerSocket(PORT);
			Socket client = server.accept();
			
			ClientWorker worker = new ClientWorker(client);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
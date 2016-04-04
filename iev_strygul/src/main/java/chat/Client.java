package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Thread {
	public final int PORT = 3021;
	private Socket sock;
	private ServerWriter writer;
	private boolean stop = false;
	
	
	@Override
	public void run() {
		try {
			sock = new Socket("localhost", PORT);
			System.out.println("Created new client");
			ClientReader reader = new ClientReader(sock);
			ClientWriter writer = new ClientWriter(sock);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

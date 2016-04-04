package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Thread {
	
	public final int PORT = 4444;
	private Socket sock;
	private ServerWriter writer;
	
	
	@Override
	public void run() {
		try {
			sock = new Socket("localhost", PORT);
			ClientReader reader = new ClientReader(sock);
			ClientWriter writer = new ClientWriter(sock);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

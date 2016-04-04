package chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientWriter implements Runnable {
	
	private Socket client;
	private Thread thrd;
	private DataOutputStream out;
	private String message = "o-lo-lo!";

	public ClientWriter(Socket sock) {
		client = sock;
		thrd = new Thread(this);
		thrd.setDaemon(true);
		thrd.start();
	}

	@Override
	public void run() {
		try {
			out = new DataOutputStream(client.getOutputStream());
			out.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

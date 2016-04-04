package chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReader implements Runnable {
	private Thread thrd;
	private Socket client;
	private DataInputStream in;
	private String message;
	private boolean stop = false;
	public static final int PORT = 4444;
	
	public ClientReader(Socket client) {
		this.client = client;
		thrd = new Thread(this);
		thrd.setDaemon(true);
		thrd.start();
	}

	@Override
	public void run() {
		try {
			in = new DataInputStream(client.getInputStream());
			while(!stop) {
				message = in.readUTF();
				System.out.println(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

package chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerReader implements Runnable {
	private Thread thrd;
	private Socket client;
	private ServerWriter writer;
	private DataInputStream in;
	private boolean stop = false;


	public ServerReader(Socket c, ServerWriter w) {
		client = c;
		writer = w;
		thrd = new Thread(this);
		thrd.setDaemon(true);
		thrd.start();
	}


	@Override
	public void run() {
		while (!stop) {
			try {
				in = new DataInputStream(client.getInputStream());
				String s = in.readUTF();
				writeDestination(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop() {
		stop = true;
	}
	
	public void writeDestination(String message) {
		writer.getMessage(message);
	}

}

package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	private ServerSocket server;
	public static final int PORT = 3043;
	private ServerWriter writer;
	private ServerReader reader;
	private boolean stop = false;
	
	private Server() {
		
	}
	
	public static Server builder() {
		return new Server();
	}

	@Override
	public void run() {
		try {
			server = new ServerSocket(PORT);
			System.out.println("ServerSocketCreated");
			while (!stop) {
				Socket client = server.accept();
				System.out.println("accepted client");
				writerBuilder(client);
				reader = new ServerReader(client, writer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writerBuilder(Socket client) {
		if(writer == null) {
			writer = new ServerWriter(client);
		} else {
			writer.acceptClient(client);
		}
		
	}

	public void shutDownDaemons() {
		writer.shutDown();
		reader.shutDown();
		stop = true;
		System.out.println(Thread.currentThread().getName());
	}

}
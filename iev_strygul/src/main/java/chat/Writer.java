package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Writer implements Runnable {
	
	private Socket sock;
	private DataInputStream in;
	private DataOutputStream out;
	
	Writer(Socket s) {
		sock = s;
	}

	@Override
	public void run() {
		try {
			in = new DataInputStream(sock.getInputStream());
			out = new DataOutputStream(sock.getOutputStream());
			String inMessage = in.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

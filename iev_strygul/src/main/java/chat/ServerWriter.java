package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerWriter implements Runnable {
	
	private ArrayList<DataOutputStream> arrOut = new ArrayList<>();
	private String newMessage;
	private boolean isNewMessage = false;
	private Thread thrd;
	private Socket client;
	private boolean stop = false;
	
	public ServerWriter(Socket s) {
		try {
			arrOut.add(new DataOutputStream(s.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		thrd = new Thread(this);
		thrd.setDaemon(true);
		thrd.start();
	}

	@Override
	public void run() {
		while(!stop) {
			if(isNewMessage) {
				for(DataOutputStream out : arrOut) {
					try {
						out.writeUTF(newMessage);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					isNewMessage = false;
				}
			}
		}	
	}

	public void acceptClient(Socket client) {
		try {
			arrOut.add(new DataOutputStream(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getMessage(String s) {
		newMessage = s;
		isNewMessage = true;	
	}
	
	public void stop() {
		stop = true;
	}

	
}

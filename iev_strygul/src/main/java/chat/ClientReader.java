package chat;

import java.io.*;
import java.net.Socket;

public class ClientReader implements Runnable {
	private Thread thrd;
	private Socket client;
	private DataInputStream in;
	private String message;
	private boolean stop = false;
	private PrintWriter writeToFile;
	private File file;
	private MyTextArea textArea;
	
	public ClientReader(Socket client, File file) {
		this.client = client;
		this.file = file;
		try {
			writeToFile = new PrintWriter(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
				writeToFile.println(message);
				writeToFile.flush();
				if(textArea != null) {
					textArea.notifyAboutNewMessage();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writeToFile.close();
		}
		
	}
	
	public void shutDown() {
		stop = true;
		System.out.println("ClientReader daemons closed");
	}

	public void passTextArea(MyTextArea previousTexts) {
		textArea = previousTexts;
		
	}
}

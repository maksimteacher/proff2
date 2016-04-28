package chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientWriter implements Runnable {
	
	private Socket client;
	private Thread thrd;
	private DataOutputStream out;
	private String message;
	private boolean stop = false;
	Object locker = new Object();

	public ClientWriter(Socket sock) {
		client = sock;
		try {
			out = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		thrd = new Thread(this);
		thrd.setDaemon(true);
		thrd.start();
	}

	@Override
	public void run() {
		synchronized(locker) {
			try {
				while(!stop) {
					locker.wait();
					out.writeUTF(message);
					System.out.println("Отсылаем сообщение " + message);
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendNewMessage(String s) {
		synchronized(locker) {
			message = s;
			locker.notifyAll();
		}

	}
	
	public void shutDown() {
		stop = true;
		System.out.println("ClientWriter daemons closed");
	}
	
}

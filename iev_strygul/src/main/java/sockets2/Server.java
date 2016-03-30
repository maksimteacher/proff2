package sockets2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	public static int port1 = 4374;
	private boolean stop = false;
	
	@Override
	public void run() {
		ServerSocket serverSock = null;
		
		try {
			serverSock = new ServerSocket(port1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(!stop) {
			try {		
				System.out.println("Waiting for a client...");
				System.out.println();
				
				Socket clientSock = serverSock.accept();
				ClientWorker w = new ClientWorker(clientSock);
				Thread th = new Thread(w);
				th.start();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close() {
		stop = true;
	}
}

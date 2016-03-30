package Action9;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainSocket {

	public static void main(String[] args) {
		ServerSocketExample serversocket = new ServerSocketExample();
		ClientOne socketexample = new ClientOne();
		serversocket.start();
		socketexample.start();
	}
	public class ServerMultiClient /* extends Thread */{
		public void run() throws IOException{
			ServerSocket srvSocket = new ServerSocket(3150);
	        while (true) {
	            Socket socket;
	            try {
	                socket = srvSocket.accept();
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }

	            sendToOtherThread(socket);
	        }
			
		}
		public void sendToOtherThread(Socket socket){
			// send socket to new Thread
		}
	}
	}


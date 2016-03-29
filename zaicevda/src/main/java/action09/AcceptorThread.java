package action09;

import java.net.ServerSocket;
import java.net.Socket;

public class AcceptorThread extends Thread {
	ServerSocket srv;
	int SocketCounter = 0;
	public Socket[] SockArr;

	public AcceptorThread(ServerSocket s) {
		srv = s;
	}

	@Override
	public void run() {
		while (true) {
			try {
				SockArr[SocketCounter] = srv.accept();
				System.out.println(SocketCounter + " socket(s) was accepted");
				SocketCounter++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
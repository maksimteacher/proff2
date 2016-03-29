package action09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExampleTest extends Thread {
	public static int port = 4444;

	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(port);
			AcceptorThread waitor = new AcceptorThread(server);
			waitor.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
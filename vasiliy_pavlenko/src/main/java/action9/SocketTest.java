package action9;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {
	
	public static int port = 3150;
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket servSocketEx = null;
		try {
			servSocketEx = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Socket socket = servSocketEx.accept();
		InputStream in = socket.getInputStream();
		
		while (true) {
			
		}
		
	}
}

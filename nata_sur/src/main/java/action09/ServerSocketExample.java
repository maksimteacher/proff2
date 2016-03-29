package action09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample extends Thread {
	public static int port = 3150;

	@Override
	public void run() {

		try {
			ServerSocket server = new ServerSocket(port);

			Socket socket = server.accept();
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);

			String messageRead = "";
			String messageWrite = "Message for send";
			while (true) {
				messageRead = dis.readUTF();
				dos.writeUTF(messageWrite);
				dos.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

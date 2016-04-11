package action9;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketExample extends Thread{
	public static int port = 3150;
	
	@Override
	public void run() {
		Socket socket = null;
		try {
			socket = new Socket("localhost", port);
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				String message = keyboard.readLine();
				dos.writeUTF(message);
				dos.flush();
				String backMassage = dis.readUTF();
				System.out.println("\tClient. I get message from server[" + backMassage+"] ");				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}

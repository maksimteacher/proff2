package sockets2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Thread {
	
	public int port;
	
	public Client(int port) {
		this.port = port;
	}
	
	
	@Override
	public void run() {
		try {
			Socket cSock = new Socket("localhost", port);
			InputStream inStrm = cSock.getInputStream();
			OutputStream outStrm = cSock.getOutputStream();
			
			DataOutputStream dataOut = new DataOutputStream(outStrm);
			DataInputStream dataIn = new DataInputStream(inStrm);
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
            System.out.println();
			
			while(true) {
				line = keyboard.readLine();
				System.out.println("Sending this line to the server...");
				dataOut.writeUTF(line);
				dataOut.flush();
				line = dataIn.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println("The server was very polite. It sent me this : " + line);
                System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
                System.out.println();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

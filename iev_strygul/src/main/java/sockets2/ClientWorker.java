package sockets2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientWorker implements Runnable {
	Socket client;

	ClientWorker(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {

		System.out.println("Got a client!");

		InputStream inStrm;
		try {
			inStrm = client.getInputStream();
			OutputStream outStrm = client.getOutputStream();

			DataInputStream dataInS = new DataInputStream(inStrm);
			DataOutputStream dataOutS = new DataOutputStream(outStrm);

			String line = "";
			while (true) {
				line = dataInS.readUTF();
				System.out.println("The dumb client just sent me this line : " + line);
				System.out.println("I'm sending it back...");
				dataOutS.writeUTF(line);
				dataOutS.flush();
				System.out.println("Waiting for another message");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

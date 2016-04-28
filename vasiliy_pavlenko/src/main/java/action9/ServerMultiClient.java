package action9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultiClient {
	public void run() throws IOException{
		ServerSocket srvSocket = new ServerSocket(3850);
        while (true) {
            Socket socket;
            try {
                socket = srvSocket.accept();
                sendToOtherThread(socket);
            } catch (IOException e) {
            	if (srvSocket != null && !srvSocket.isClosed()) {
            		srvSocket.close(); 
            	}
            } finally {
            if (srvSocket != null && !srvSocket.isClosed()) {
        		srvSocket.close(); 
        		}
            }
        }
		
	}
	public void sendToOtherThread(Socket socket) throws IOException{
		InputStream in = socket.getInputStream();
		OutputStream outMult2 = socket.getOutputStream();
		OutputStream outMult10 = socket.getOutputStream();

		DataInputStream dis = new DataInputStream(in);
		DataOutputStream dosMult2 = new DataOutputStream(outMult2);
		DataOutputStream dosMult10 = new DataOutputStream(outMult10);

		String messageRead = "";
		while (true) {
			messageRead = dis.readUTF();
			if (messageRead.equals("exit")) {
				break;
			}
			int result = Integer.parseInt(messageRead);
			dosMult2.writeUTF(String.valueOf(result*2));
			dosMult2.flush();
			dosMult10.writeUTF(String.valueOf(result*10));
			dosMult10.flush();
		}
	}
}

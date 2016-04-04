package Action9;

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

public class MySocket extends Thread {
    public static int port = 3151;

    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket("localhost", port);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            DataInputStream dis = new DataInputStream(in);
            DataOutputStream dos = new DataOutputStream(out);

            while (true) {
                String backMassage = dis.readUTF();
                switch (backMassage.charAt(0)) {
                    case '1':
                        System.out.println("\tClient. Thread" + Thread.currentThread().getName() + "   " + Integer.parseInt(backMassage.substring(2, backMassage.length())) * 2);
                        break;
                    case '2':
                        System.out.println("\tClient. Thread" + Thread.currentThread().getName() + "   " + Integer.parseInt(backMassage.substring(2, backMassage.length())) * 10);
                        break;
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

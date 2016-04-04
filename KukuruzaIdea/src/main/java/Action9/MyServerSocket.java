package Action9;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServerSocket extends Thread {
    public static int port = 3151;
    private ArrayList<Socket> sockets = new ArrayList<>();

    @Override
    public void run() {

        try {
            java.net.ServerSocket server = new java.net.ServerSocket(port);
            while (true) {
                Socket socket = server.accept();
                sendToNewThread(socket);
                sockets.add(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendToNewThread(Socket socket) {
        new Thread(() -> {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = socket.getInputStream();
                out = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            DataInputStream dis = new DataInputStream(in);
            DataOutputStream dos = new DataOutputStream(out);
            String messageRead = "";
            String messageWrite = "";
            while (true) {
                //String message = keyboard.readLine();
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                try {
                    System.out.println("i got messege" + Thread.currentThread().getName());
                    //messageRead = dis.readUTF();
                    dos.writeUTF(keyboard.readLine());
                    dos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
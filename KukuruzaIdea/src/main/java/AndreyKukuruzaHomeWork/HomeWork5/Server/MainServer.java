package AndreyKukuruzaHomeWork.HomeWork5.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MainServer extends Thread {
    public static int port = 3151;
    private ArrayList<ServerConnection> connections = new ArrayList<>();

    @Override
    public void run() {

        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket socket = server.accept();
                ServerConnection connection = new ServerConnection(socket);
                connections.add(connection);
                new Thread(connection).start();
                System.out.println("Клиент приконектился");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ServerConnection implements Runnable {
        Socket socket;

        public ServerConnection(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Поток серверного сокета стартовал");
            try (DataInputStream dis = new DataInputStream(socket.getInputStream());
                 DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
                String messageRead;
                while (true) {
                    messageRead = dis.readUTF();
                    System.out.println(messageRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

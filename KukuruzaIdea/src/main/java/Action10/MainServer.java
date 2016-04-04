package Action10;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainServer {
    static List<SocketToClient> sockets = new ArrayList<>();
    static ConsoleRun console = new ConsoleRun();

    public static void main(String[] args) throws Exception {
        new MainServer().start();
    }

    public void start() throws IOException {
        console.start();

    }


}

class ConsoleRun extends Thread {
    public void run() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String str = scan.nextLine();
            int num = scan.nextInt();
            String s = MainServer.sockets.get(num).print(str);
            System.out.println(s);
        }
    }
}

class SocketToClient extends Thread {
    Socket socket;
    InputStream in = null;
    OutputStream out = null;
    DataInputStream dis = null;
    DataOutputStream dos = null;

    public SocketToClient(Socket sock) {
        socket = sock;
    }

    public void run() {
        try {
            in = socket.getInputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            out = socket.getOutputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        dis = new DataInputStream(in);
        dos = new DataOutputStream(out);
        while (true) {

        }
    }

    public String print(String str) {
        String s = "";
        try {
            s = dis.readUTF();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
    }
}

class Client extends Thread {
    ServerSocket srvSocket;

    Client() {
        try {
            srvSocket = new ServerSocket(3150);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true)

        {
            Socket socket;
            try {
                socket = srvSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sendToOtherThread(socket);
        }
    }

    public void sendToOtherThread(Socket socket) {
        // send socket to new Thread
        SocketToClient obj = new SocketToClient(socket);
        //sockets.add(obj);
        obj.start();
    }

}
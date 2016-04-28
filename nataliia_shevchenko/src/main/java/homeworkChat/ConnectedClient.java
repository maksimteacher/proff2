package homeworkChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectedClient extends Thread {
    private Socket sock;
    private BufferedReader input;
    private PrintWriter output;

    public ConnectedClient(Socket s) throws IOException {
        sock = s;
        System.out.println("new user connected from " + s.getInetAddress().toString());
        input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        output = new PrintWriter(sock.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (sock.isConnected()) {
                String readed = input.readLine();
                for (ConnectedClient c : Server.clients) {
                    c.send(readed);
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("user disconnected from " + sock.getInetAddress().toString());
        }
    }

    public void send(String s) throws IOException {
        output.println(s);
        output.flush();
    }
}
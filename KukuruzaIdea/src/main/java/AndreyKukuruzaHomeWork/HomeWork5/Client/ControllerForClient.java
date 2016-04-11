package AndreyKukuruzaHomeWork.HomeWork5.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ControllerForClient {
    public static int port = 3151;
    boolean send = false;

    {
        ServerConnection serverConnection = new ServerConnection();
        new Thread(serverConnection).start();
    }

    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;
    @FXML
    private Button button;

    @FXML
    protected void onAction(ActionEvent actionEvent) throws IOException {
        send = true;
        System.out.println("button pressed");
    }


    class ServerConnection implements Runnable {
        @Override
        public void run() {
            Socket socket = null;
            try {
                socket = new Socket("localhost", port);
                System.out.println(socket.getPort());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    if (send) {
                        dos.writeUTF(textField.getText());
                        dos.flush();
                        send = false;
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
}
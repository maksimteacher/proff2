package Action9;

public class Main {
    public static void main(String[] args) {
        MyServerSocket myServerSocket = new MyServerSocket();
        MySocket mySocket = new MySocket();
        MySocket mySocket2 = new MySocket();
        myServerSocket.start();
        mySocket.start();
        mySocket2.start();
    }
}

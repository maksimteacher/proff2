package action09;

public class Main {
	public static void main(String[] args) {
		ServerSocketExample sse = new ServerSocketExample();
		SocketExample se = new SocketExample();
		
		se.start();
		sse.start();
	}

}

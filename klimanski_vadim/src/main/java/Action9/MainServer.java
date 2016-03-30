package Action9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainServer {
		
	static List<SocketToClient> sockets = new ArrayList<>();
	static ConsoleRun console = new ConsoleRun();
	
		public static void main(String[] args) throws Exception {
						
			MainServer MainServer = new MainServer();
			MainServer.start();
		}
		private void start() {
					}
		public void print(String str) {
			return;
		}
					}

class SocketToClient extends Thread {

	public String print(String str) {
			return str;
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

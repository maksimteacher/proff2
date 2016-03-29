package action06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monitor extends Thread{
	//private Thread ThreadCreator;
	
	
	@Override
	public void run() {
		while(true) {
			if(isInterrupted()) break;
		}
		System.out.println("hello thread");
	}
	
	public class ThreadCreator {
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		//(new ThreadCreator()).start();
		
		//
		//ThreadCreator
		//ThreadWriter
	}

}

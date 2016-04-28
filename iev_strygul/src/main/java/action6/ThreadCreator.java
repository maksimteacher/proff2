package action6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThreadCreator extends Thread {
	
	private Monitor monitor;
	
	
	public ThreadCreator(Monitor monitor) {
		this.monitor = monitor;
	}

	@Override
	public void run() {
		System.out.println("Creator enters");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monitor.write();
		System.out.println("Creator finished writing the file");
	}

}

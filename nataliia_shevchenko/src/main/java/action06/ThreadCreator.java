package action06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThreadCreator extends Thread {
	private FileWriter fw;
	private Scanner scan;
	MyThread1 obj = new MyThread1();

	public ThreadCreator() {

	}

	public ThreadCreator(File file) {
		try {
			fw = new FileWriter(file);
			scan = new Scanner(System.in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			if (isInterrupted())
				break;
		}
		System.out.println("done MyThread1");
	}

	public boolean isInterrupted() {
		return obj.isInterrupted();
	}

	public void start() {
		obj.start();
	}

}

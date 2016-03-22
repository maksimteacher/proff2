package threads.files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Monitor {
	private File file1;
	private File file2;
	private Thread t1;
	private Thread t2;
	// private Object sync;

	Monitor(File file1, File file2) {
		this.file1 = file1;
		this.file2 = file2;
		// sync = new Object();
		t1 = new ThreadCreator(this);
		t2 = new ThreadWriter(this);
		t2.setDaemon(true);
	}

	public void start() {
		t2.start();
		t1.start();
		
	}

	public synchronized void scan() {

		Scanner scn = new Scanner(System.in);
		try (FileWriter fw = new FileWriter(file1)) {
			boolean stop = false;
			while (!stop) {
//				if (!stop) {
				String read = scn.nextLine();
				if (read.toLowerCase().equals("exit") || read.toLowerCase().equals("stop")) {
					stop = true;
				} else {
					fw.write(read + System.lineSeparator());
					fw.flush();
					System.out.println(t1.getName() + " " + t1.getState());
					System.out.println(t2.getName() + " " + t2.getState());
					System.out.println(stop);
					// fw.close();
				}
//				}
//				scn.close();
				 notify();
			}

			System.out.println("Creator STOPED!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public synchronized void rewrite() {

		try {
			System.out.println("thread2 started");
			wait();
			System.out.println("thread2 continued");
			System.out.println(t1.getName() + " " + t1.getState());
			System.out.println(t2.getName() + " " + t2.getState());
			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(file2);
			Scanner scn = new Scanner(fr);
			int n = 1;
			while (scn.hasNext()) {
				String str = scn.nextLine();
				fw.write(str + System.lineSeparator());
				System.out.println("line" + n++ + ": " + str);
			}
			fw.flush();
			fw.close();
//			scn.close();
			System.out.println("Copy completed...");
			notify();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void state() {
		System.out.println(t1.getName() + " " + t1.getState());
		System.out.println(t2.getName() + " " + t2.getState());
		
	}
}

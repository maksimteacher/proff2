package action6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Monitor {
	private File file1;
	private File file2;
	private ThreadCreator creator;
	private ThreadWriter writer;
	
	public Monitor(File nameFile1, File nameFile2) {
		file1 = nameFile1;
		file2 = nameFile2;
		creator = new ThreadCreator(this);
		writer = new ThreadWriter(this);
	}
	
	public void start() {
		creator.start();
		writer.start();
		try {
			creator.join();
			writer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Program finished");
	}
	
	public synchronized void write() {
		try (FileWriter fw = new FileWriter(file1);
			Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter text");
			String text = scan.nextLine();
			fw.write(text);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		notify();
	}
	
	public synchronized void rewrite() {
		System.out.println("Writer enters and waits for notify");
		try {
			wait();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Writer was woken up");
		try (Scanner scan = new Scanner(file1);
			FileWriter fw = new FileWriter(file2)) {
			String str = scan.nextLine();
			fw.write(str);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("File copied");
	}

}

package action09;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/*
 Задача:
Написать класс Monitor(nameFile1,nameFile2), в котором два потока.

1. Поток 1(ThreadCreator), считывает строку с консоли записывает в nameFile1, 
 будит поток 2.(objSynchro.notify())
 
2. Поток 2(ThreadWriter), копирует nameFile1 в nameFile2 и засыпает. 
 (objSynchro.wait()) 

Примечание: 
1. если с консоли введено слово "exit" или "quit", то поток №1 останавливать.
2. продумать остановку и второго потока.
 * */
public class Monitor1{
	public static Object mutex = new Object();
	public static String file1 = "file1.txt";
	public static String file2 = "file2.txt";

	public ThreadCreator1 thread1;
	public ThreadWriter1 thread2;

	public static void main(String[] args) {
		new Monitor().start();
	}

	public void start() {
		thread2 = new ThreadWriter1();
		thread1 = new ThreadCreator1(thread2);
		
		thread1.start();

		System.out.println("Main thread terminated!");
	}
}

class ThreadCreator1 extends Thread {
	public ThreadCreator1(Thread daemon){
		daemon.setDaemon(true);
		daemon.start();
	}
	@Override
	public void run() {
		while (true) {
			if (isInterrupted()) break;
			Scanner scan = new Scanner(System.in);
			String str = scan.nextLine();
			if (str.equalsIgnoreCase("stop")) interrupt();
			try (FileWriter fw = new FileWriter(Monitor.file1);) {
				fw.write(str);
				synchronized (Monitor1.mutex) {
					Monitor1.mutex.notify();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ThreadCreator terminated!");
	}
}

class ThreadWriter1 extends Thread {

	@Override
	public void run() {
		while (true) {
			if (isInterrupted())
				break;
			synchronized (Monitor1.mutex) {
				try {
					Monitor1.mutex.wait();
				} catch (InterruptedException e) {
					interrupt();
				}
			}
			StringBuilder sb = new StringBuilder();
			try {
				try (FileReader fr1 = new FileReader(Monitor.file1);
						Scanner scanFile1 = new Scanner(fr1);
						FileReader fr2 = new FileReader(Monitor.file2);
						Scanner scanFile2 = new Scanner(fr2);) {
					while (scanFile2.hasNextLine()) {
						sb.append(scanFile2.nextLine() + "\n");
					}
					while (scanFile1.hasNextLine()) {
						sb.append(scanFile1.nextLine() + "\n");
					}
				}
				try (FileWriter fwFile2 = new FileWriter(Monitor.file2);) {
					fwFile2.write(sb.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ThreadWriter terminated!");
	}
}

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
public class Monitor {
	private static Object objSynchro = new Object();
	public static String file1 = "file1.txt";
	public static String file2 = "file2.txt";

	public ThreadCreator thread1;
	public ThreadWriter thread2;

	public static void main(String[] args) {
		new Monitor().start();
	}

	public void start() {
		thread2 = new ThreadWriter(objSynchro);
		thread1 = new ThreadCreator(objSynchro, thread2);

		thread1.start();
		thread2.start();

		System.out.println("Main thread terminated!");
	}
}

class ThreadCreator extends Thread {
	Object mutex;
	Thread threadDaemon;

	public ThreadCreator(Object m, Thread daemon) {
		mutex = m;
		threadDaemon = daemon;
	}

	@Override
	public void run() {
		if (mutex == null) {
			System.err.println("ThreadCreator: Do not created synchronized object!");
			return;
		}
		while (true) {
			if (isInterrupted()) {
				threadDaemon.interrupt();
				break;
			}
			Scanner scan = new Scanner(System.in);
			String str = scan.nextLine();
			if (str.equalsIgnoreCase("stop")) interrupt();
			try (FileWriter fw = new FileWriter(Monitor.file1);) {
				fw.write(str);
				synchronized (mutex) {
					mutex.notify();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ThreadCreator terminated!");
	}
}

class ThreadWriter extends Thread {
	Object mutex;

	public ThreadWriter(Object m) {
		mutex = m;
	}

	@Override
	public void run() {
		if (mutex == null) {
			System.err.println("ThreadWriter: Do not created synchronized object!");
			return;
		}
		while (true) {
			if (isInterrupted())
				break;
			synchronized (mutex) {
				try {
					mutex.wait();
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

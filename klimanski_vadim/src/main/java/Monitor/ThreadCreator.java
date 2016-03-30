package Monitor;

import java.io.IOException;
import java.util.Scanner;

public class ThreadCreator implements Runnable {
	ThreadWriter threadWriter;
	String str1;
	// FileWriter fw;
	Thread thread = null;

	public ThreadCreator(String str1) throws IOException {
		thread = new Thread(this);
		this.str1 = str1;
		// this.fw=new FileWriter(str1);
	}

	public void setThreadWriter(ThreadWriter threadWriter) {
		this.threadWriter = threadWriter;
	}

	synchronized public void notif() {
		this.notify();
	}

	@Override
	public void run() {

		Scanner scan = new Scanner(System.in);
		while (true) {
			if (isInterrupted())
				break;
			System.out.println("Ввод для первого потока");
			String str = scan.nextLine();
			// Тут делаем все что хотим .........
			threadWriter.notif(); // будим второй поток
			if (str.equals("exit") || str.equals("quit")) {
				interrupt();
			}
		}
		System.out.println("Поток 1 остановлен");
		thread.stop();

	}

	public boolean isInterrupted() {
		return thread.isInterrupted();
	}

	public void start() {
		thread.start();
	}

	public void interrupt() {
		thread.interrupt();
	}

}
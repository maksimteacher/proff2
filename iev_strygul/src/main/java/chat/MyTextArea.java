package chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.control.TextArea;

public class MyTextArea extends TextArea {
	private File file;
	private Object locker = new Object();
	private boolean stop = false;

	public MyTextArea(File file) {
		super();
		this.file = file;
	}

	public void loadHistory() {
		Thread thrd = new Thread(new MonitorHistory());
		thrd.start();
	}
	
	public void notifyAboutNewMessage() {
		synchronized(locker) {
			locker.notify();
		}
	}

	private class MonitorHistory implements Runnable {

		@Override
		public void run() {

			do {
				String line;
				BufferedReader buffRead;
				try {
					buffRead = new BufferedReader(new FileReader(file));
					StringBuilder sb = new StringBuilder();
					while ((line = buffRead.readLine()) != null) {
						sb.append(line);
						sb.append("\n");
					}
					buffRead.close();
					setText(sb.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}

				waitNewMessage();
			} while (!stop);

		}

		private void waitNewMessage() {
			synchronized (locker) {
				try {
					locker.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}

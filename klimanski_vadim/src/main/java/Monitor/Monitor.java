package Monitor;

import java.util.Scanner;

class Monitor implements Runnable {

	Thread obj = null;

	public Monitor() {
		obj = new Thread(this);
	}

	@Override
	public void run() {
		while (true) {
			if (isInterrupted())
				break;
		}
		System.out.println("done");
	}

	public boolean isInterrupted() {
		return obj.isInterrupted();
	}

	public void start() {
		obj.start();
	}

	public void interrupt() {
		obj.interrupt();
	}
}

package threads.files;

public class ThreadWriter extends Thread {
	private Monitor m;
	
	public ThreadWriter(Monitor m) {
		this.m = m;
	}
	
	@Override
	public void run() {
//		while (true) {
			m.rewrite();
//		}
	}

}

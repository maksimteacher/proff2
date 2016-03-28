package action6;

public class ThreadWriter extends Thread {
	
	private Monitor monitor;
	
	public ThreadWriter(Monitor monitor) {
		this.monitor = monitor;
	}

	@Override
	public void run() {
		monitor.rewrite();
		System.out.println("Writer falls asleep");
	}

}

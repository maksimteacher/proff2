package alexThread;

public class ThreadCreator extends Thread {
	private Monitor m;
	
	public ThreadCreator(Monitor m) {
		this.m = m;
	}

	@Override
	public void run() {
//		while (true) {
		try {
			Thread.sleep(1000);
			m.scan();
			Thread.sleep(3000);
			m.state();
			System.out.println("The End!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
//		}
	}
}


package threads.files1;

public class ThreadCreator extends Thread {
	private Monitor m;
	
	public ThreadCreator(Monitor m) {
		this.m = m;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(100);
			m.scan();
//			Thread.sleep(2000);

			System.out.println("The End!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}
}

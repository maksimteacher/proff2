package action06;

public class ThreadExample {
	public static void main(String[] args) throws InterruptedException {
		MyThread1 obj1 = new MyThread1();
		obj1.start();

		MyThread2 objToThread = new MyThread2();
		Thread obj2 = new Thread(objToThread);
		obj2.start();
		Thread.sleep(1);
		obj2.interrupt();

		MyThread3 obj3 = new MyThread3();
		obj3.start();

		obj2.getState(); // NEW, RUNNABLE, WAITING, TIMED_WAITING, BLOCKED,
							// TERMINATED
		// obj1.stop();//deprecated
		obj1.interrupt();
		obj1.join(); // Waits for this thread to die
		obj1.setDaemon(true);
		obj1.setPriority(Thread.MAX_PRIORITY); // 10
		// Thread.MIN_PRIORITY = 1
		// Thread.NORM_PRIORITY = 5
		Thread.currentThread();

		Thread.currentThread();
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		while (true) {
			if (isInterrupted())
				break;
		}
		System.out.println("done MyThread1");
	}
}

class MyThread2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
			// Thread.currentThread().interrupt();
			// if(isInterrupted())break;//error
		}
		System.out.println("done MyThread2");
	}
}
//в третьем примере мы реализуем поток в классе и инкапсулируем методы 
class MyThread3 implements Runnable {
	Thread obj = null;

	public MyThread3() {
		obj = new Thread(this);
	}

	@Override
	public void run() {
		while (true) {
			if (isInterrupted())
				break;
		}
		System.out.println("done MyThread3");
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

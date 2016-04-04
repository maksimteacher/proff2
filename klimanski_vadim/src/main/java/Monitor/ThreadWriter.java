package Monitor;

class  ThreadWriter implements Runnable {
	int time = 0;
	ThreadCreator threadCreator;
	String str1;
	String str2;
	Thread thread = null;

	public ThreadWriter(String str1, String str2) {
		thread = new Thread(this);
		this.str1 = str1;
		this.str2 = str2;
	}

	public void setThreadCreator(ThreadCreator threadCreator) {
		this.threadCreator = threadCreator;
	}

	synchronized public void notif() {
		this.notify();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		while (true) {
			if (isInterrupted())
				break;
			System.out.println("Поток 2 проснулся");
			time++;
			// Вставляем сюда свой код ...............
			synchronized (this) {
				try {
					System.out.println("Поток два заснул  time= " + time);
					this.wait(); // поток 2 заснул
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			if (time > 10)
				interrupt(); // останавлюем второй поток
		}
		System.out.println("Поток 2 остановлен");
		try {
			thread.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
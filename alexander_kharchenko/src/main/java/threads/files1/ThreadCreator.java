package threads.files1;

import java.util.Scanner;

public class ThreadCreator extends Thread {
	private Monitor m;
	
	public ThreadCreator(Monitor m) {
		this.m = m;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(100);
			

				@SuppressWarnings("resource")
				Scanner scn = new Scanner(System.in);

				boolean stop = false;
				boolean copy = false;
				while (!stop) {
					String read = scn.nextLine();
					if (read.toLowerCase().equals("exit") || read.toLowerCase().equals("stop")) {
						stop = true;
					} else {
						m.write(read, copy);
						if (!copy) {
							copy = true;
						}
						System.out.println("!!!");

					}
					

				}
			
//			Thread.sleep(2000);

			System.out.println("The End!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}
}

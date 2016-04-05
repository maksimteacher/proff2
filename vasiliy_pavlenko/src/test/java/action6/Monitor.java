package action6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Monitor {

	private String nameFile1;
	private String nameFile2;

	public Monitor(String nameFile1, String nameFile2) {
		this.nameFile1 = nameFile1;
		this.nameFile2 = nameFile2;
		
		ThreadCreator tc = new ThreadCreator();
		synchronized (tc) {
			tc.run();
		}
		
	}
	
	class ThreadCreator extends Thread {
		@Override
		public void run() {
			
			Scanner sc = new Scanner(System.in);
			
			while (sc.hasNext()) {
				String str = sc.nextLine();
				File file = new File(nameFile1);
				try {
					if(!file.exists()){
			            file.createNewFile();
			        }
					
			        PrintWriter out = new PrintWriter(file.getAbsoluteFile());

			        try {
			            out.print(str);
			        } finally {
			            out.close();
			        }
					
				} catch (IOException e) {
			        throw new RuntimeException(e);
				}
				
				ThreadWriter tw = new ThreadWriter();
				synchronized (tw) {
					tw.notify();
				}
			}
			
		}
	}

	class ThreadWriter extends Thread {
		@Override
		public void run() {
			
			
			
		}
		
		
	}
	
}

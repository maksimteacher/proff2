package threads.files1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Monitor {
	private File file1;
	private File file2;
	private Thread t1;
	private Thread t2;
	private Object sync;

	Monitor(File file1, File file2) {
		this.file1 = file1;
		this.file2 = file2;
		sync = new Object();
		t1 = new ThreadCreator(this);
		t2 = new ThreadWriter(this);
		t2.setDaemon(true);
	}

	public void start() {
		t2.start();
		t1.start();

	}

	public void write(String str, boolean copy) {
		synchronized (sync) {

			StringBuffer sb = new StringBuffer();
			try (FileReader fr = new FileReader(file1)) {
				if (copy) {

					@SuppressWarnings("resource")
					Scanner scn = new Scanner(fr);

					while (scn.hasNext()) {
						sb.append(scn.nextLine()).append(System.lineSeparator());
					}
				}
				sb.append(str);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try (FileWriter fw = new FileWriter(file1)) {

				fw.write(sb.toString() + System.lineSeparator());
				fw.flush();
				sync.notify();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// }

	public void rewrite() {
		synchronized (sync) {
			try {
				System.out.println("thread2 started");
				sync.wait();
				System.out.println("thread2 continued");
				FileReader fr = new FileReader(file1);
				FileWriter fw = new FileWriter(file2);
				@SuppressWarnings("resource")
				Scanner scn = new Scanner(fr);
				int n = 1;
				while (scn.hasNext()) {
					String str = scn.nextLine();
					fw.write(str + System.lineSeparator());
					System.out.println("line" + n++ + ": " + str);
				}
				fw.flush();
				fw.close();
				fr.close();
				System.out.println("Copy completed...");
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

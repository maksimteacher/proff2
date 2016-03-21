package Monitor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThreadCreator extends Monitor {

	private static File file1;

	public ThreadCreator(File file1) {
		this.file1 = file1;
	}

	Scanner scan = new Scanner(System.in);

	public void run() {
		try (FileWriter file = new FileWriter(file1)) {
			boolean isInterrupted = false;
			while (!isInterrupted) {
				String read = scan.nextLine();
				if (read.equals("exit") || read.equals("quit")) {
					isInterrupted = true;
				} else {
					file.write(read + System.lineSeparator());
					file.flush();
				}
			}
			notify();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

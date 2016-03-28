package Monitor;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ThreadWrite extends Monitor{
	private File file2;

	public ThreadWrite(File file2) {
		this.file2 = file2;
	}

	public synchronized void write() {

		/*try {
			wait();
			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(file2);
			Scanner scn = new Scanner(fr);
		*/}

}

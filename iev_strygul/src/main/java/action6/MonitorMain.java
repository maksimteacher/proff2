package action6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MonitorMain {

	public static void main(String[] args) {
		
		File file1 = new File("file1.txt");
		File file2 = new File("file2.txt");
		Monitor monitor = new Monitor(file1, file2);
		
		monitor.start();
		
	}

}

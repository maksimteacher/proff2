package Monitor;

import java.io.IOException;
import java.util.Scanner;

public class Monitor {

	public static void main(String[] args) throws IOException {
		String str1 = "file.txt";
		String str2 = "file2.txt";

		ThreadCreator threadCreator = new ThreadCreator(str1);
		ThreadWriter threadWriter = new ThreadWriter(str1, str2);
		threadCreator.setThreadWriter(threadWriter);
		threadWriter.setThreadCreator(threadCreator);
		threadCreator.start();
		threadWriter.start();

	}

}


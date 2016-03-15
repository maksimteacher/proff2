package threads.files;

import java.io.File;

public class Runner {

	public static void main(String[] args) {
		File f1 = new File("src/main/java/threads/files/first.txt");
		File f2 = new File("src/main/java/threads/files/second.txt");
		Monitor m = new Monitor(f1, f2);
		m.start();
	}

}

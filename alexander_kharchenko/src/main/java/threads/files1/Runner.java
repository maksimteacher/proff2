package threads.files1;

import java.io.File;

public class Runner {

	public static void main(String[] args) {
		String path = "src/main/java/threads/files1/";
		
		File f1 = new File(path + "first.txt");
		File f2 = new File(path + "second.txt");
		Monitor m = new Monitor(f1, f2);
		m.start();
	}

}

package alexThread;

import java.io.File;

public class Runner {

	public static void main(String[] args) {
		File f1 = new File("first.txt");
		File f2 = new File("second.txt");
		Monitor m = new Monitor(f1, f2);
		m.start();
	}

}

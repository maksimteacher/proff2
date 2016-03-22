package action01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task01 {
	public static void main(String[] args) throws IOException {
		String sFile = "file1.txt";
		File file = new File("file2.txt");
		file.isFile();
		file.isDirectory();
		file.exists();
		file.createNewFile();
		file.mkdir();
		file.mkdirs();
		File[] arr = file.listFiles();
		if (arr != null)
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i].getName());
			}
		FileWriter fw = new FileWriter(sFile);
		fw.write("Hello1");
		fw.write("Hello2");
		fw.flush();
		fw.close();

		FileReader fr = new FileReader(sFile);
		Scanner scan = new Scanner(fr);
		int i = 0;
		while (scan.hasNextLine()) {
			System.out.println(++i + scan.nextLine());
		}
		scan.close();
	}
}

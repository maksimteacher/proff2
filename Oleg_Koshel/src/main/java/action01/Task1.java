package action01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) throws IOException {
		String sFile = "file1.txt";
		/*
		 * File file = new File("d://book/dir1/fiel2.txt"); new
		 * File("d:\\\\book\\dir2\\file.txt"); String s = File.separator;
		 * file.isFile(); file.isDirectory(); file.exists();
		 * file.createNewFile(); file.mkdir(); file.mkdirs(); File[] arr =
		 * file.listFiles();// isDirectory if(arr != null) for(int i = 0; i <
		 * arr.length;i++){ System.out.println(arr[i].getName()); }
		 *
		 */

		FileWriter fw = new FileWriter(sFile); // file
		fw.write("privet1\r\nprivet2");
		fw.write("privet1\nprivet2");
		String s1 = System.lineSeparator();
		fw.write("privet3");

		fw.flush();
		fw.close();

		FileReader fr = new FileReader(sFile);
		Scanner scan = new Scanner(fr);// System.in
		// next, nextLine, nextDouble, nextInt
		int i = 0;
		while (scan.hasNextLine()) {
			System.out.println(++i + scan.nextLine());
		}
		scan.close();
	}
}

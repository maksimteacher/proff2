package scanner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Runner {
	public static void main(String[] args) throws IOException {
		
		String i;
		String str;
//		MyScanner sc = new MyScanner(System.in);
//		i = sc.next();
//		System.out.println(i);
		
//		Scanner sc1 = new Scanner(System.in);
//		System.out.println(sc1.next());
//		
		MyScanner1 myScan = new MyScanner1(System.in);
		System.out.println(myScan.hasNextInt());
//		
		
	}
}

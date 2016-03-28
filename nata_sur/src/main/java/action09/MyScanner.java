package action09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class MyScanner {
	public static void main(String[] args) throws IOException {
		/*
		Reader system = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(system);
		String str = buff.readLine();
		System.out.println(str);
		*/
		//
		Scanner scan = new Scanner(System.in);
		/*
		if(scan.hasNextInt()){
			int k = scan.nextInt();
			System.out.println("1");
		}
		if(scan.hasNextInt()){
			int k = scan.nextInt();
			System.out.println("2");
		}
		*/
		System.out.println(scan.nextLine());
		System.out.println(scan.nextLine());
	}
	
	
	public boolean hasNextInt(){
		return false;
	}
	public boolean hasNextDouble(){
		return false;
	}
	public int nextInt(){
		return 0;
	}
	public double nextDouble(){
		return 0;
	}
	//next(), nextLine(), hasNext(), hasNextLine()
	
}

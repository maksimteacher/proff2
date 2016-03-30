package Action9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyScanner {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String str = read.readLine();
		System.out.println(str);
	
	}
	
	/*
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
	*/
	public static String ReadLine(BufferedReader read) throws IOException{
		String str = read.readLine();
		System.out.println(str);
		return str;
			}
	public static boolean ReadLineB(BufferedReader read) throws IOException{
		boolean str = read.ready();
		System.out.println(str);
		return str;
			}
	
	public static double ReadDouble(BufferedReader read) throws IOException{
		double dou =  Double.parseDouble(read.readLine());
		System.out.println(dou);
		return dou;
		
	}
	public static int ReadInt (BufferedReader read) throws IOException{
		int in = read.read();
		return 0;
			}
	
	//next(), nextLine(), hasNext(), hasNextLine()
	
}

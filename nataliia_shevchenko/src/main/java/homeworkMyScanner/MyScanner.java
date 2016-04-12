package homeworkMyScanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.InputMismatchException;
 

public class MyScanner {
	public static void main(String[] args)  {
//		Reader isr = new InputStreamReader(System.in, "numbers.txt");		
//		MyScanner myScanner1 = new MyScanner(isr);
//		System.out.println("next()=" + myScanner1.next());
//		System.out.println("next()=" + myScanner1.next());
//		System.out.println("hasNext()=" + myScanner1.hasNext());
//		System.out.println("hasNextInt()=" + myScanner1.hasNextInt());		
	}
	//=======================================================================================================
	private char delimiter;
	
	private Reader isr;
    BufferedReader br = new BufferedReader(isr);
    
	public MyScanner(Reader isr) throws IOException {
		this.isr = isr;
	}
	
	public boolean isLiteral(char ch) {
		int ascii = (int) ch;
		if (ascii != 13 & ascii != 10 & ascii != 32 & ascii != 54) {
			return true;
		} else {
			return false;
		}
	}
	
	public String next() throws IOException {		
		char charOne;
		int codeChar = 0;
		String res = "";
		codeChar = br.read();
		if (codeChar < 0){
			return res; 
		} 
		charOne = (char) codeChar;
		// пропускаем не символы		
		while (!isLiteral(charOne)){
			codeChar = br.read();
			if (codeChar < 0){
				return res; 
			}
			charOne = (char) codeChar;
		}
 
		while (!isLiteral(charOne)){
			codeChar = br.read();
			//конец файла - выходим
			if (codeChar < 0){
				return res; 
			}
			charOne = (char) codeChar;
			if (isLiteral(charOne)) {
				res += charOne;
			} else {
				break;
			}
		}
		return res;
	}
	
	public int nextInt() throws IOException{  // чтение целого числа из строки или InputMismatchException
		int res = -1;
		int codeChar = 0;
		codeChar = br.read();
		// пропускаем не символы		
		while (codeChar >= 0){
			codeChar = br.read();
			if (codeChar < 0){
				break;
			}
			if (codeChar >= 48 & codeChar <= 57) {
				res = res * 10 + ((int)((char) codeChar));
			} else {
				break;
			}
		}		
		
		if (res < 0) {
			throw new InputMismatchException();
		} else {
			return res;
		}
	}
	
	public String nextLine() throws IOException {
		return br.readLine();
	}	
	
	public boolean hasNext(){		
		return br.hashCode() == 0;
	}
	public boolean hasNextInt() throws IOException{		
		int codeChar = 0;
		codeChar = br.read();
		if (codeChar < 0){
			return false; 
		} 
 
		// пропускаем не символы		
		while (codeChar >= 0){
			codeChar = br.read();
			if (codeChar < 0){
				return false; 
			}
			if (codeChar >= 48 & codeChar <= 57) {
				return true;
			}
		}		
		return false;
	}
	
	public void useDelimiter(char delimiter){
		this.delimiter = delimiter;
	}
	
	public void close() throws IOException{
		br.close();		
	}
}
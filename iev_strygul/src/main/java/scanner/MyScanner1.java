package scanner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyScanner1 {
	
	private PushbackReader reader;
	private StringBuffer strBuff = new StringBuffer();
	
	MyScanner1(InputStream inStr) {
		reader = new PushbackReader(new InputStreamReader(inStr), 4096);
	}
	
	public boolean hasNext() throws IOException {
		char c = (char)reader.read();
		if(c != -1) {
			reader.unread(c);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasNextInt() throws IOException {
		try {
			nextInt();
			return true;
		} catch (NoSuchElementException nsee) {
			return false;
		} finally {
			undo();
		}
	}
	
	public boolean hasNextLine() throws IOException {
		if(hasNext()) {
			return true;
		} else {
			return false;
		}
	}
	
	public String next() throws IOException {
		char c = (char) nextChar();
		strBuff.setLength(0);
		StringBuffer result = new StringBuffer(); 
		
		while(isWhiteSpace(c) && hasNext()) {
			strBuff.append(c);
			c = (char) nextChar();
		}
		
		while(!isWhiteSpace(c) && hasNext()) {
			strBuff.append(c);
			result.append(c);
			c = (char) nextChar();
		}
		
		return result.toString();
	}
	
	private int nextChar() throws IOException {
		return reader.read();
	}
	
	public int nextInt() throws IOException {
		try {
			String s = next();
			return Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			throw getNoSuchElementException();
		}
	}
		

	private NoSuchElementException getNoSuchElementException() {
		return new NoSuchElementException("wrong input");
	}

	public String nextLine() throws IOException {
		StringBuffer s = new StringBuffer();
		while(hasNext()) {
			char c = (char) reader.read();
			s.append(c);
			if(c == '\n') break;
		}
		return s.toString();
	}
	
	private boolean isWhiteSpace(char c) throws IOException {
		Pattern p = Pattern.compile(" +");
		String s = "" + c;
		Matcher m = p.matcher(s);
		return m.matches();
	}
	
	private void undo() throws IOException {
		if(strBuff.length() > 0) {
			reader.unread(strBuff.toString().toCharArray());
		}
	}
}

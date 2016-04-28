package homeworkMyScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.InputMismatchException;
 

public class MyScanner2 {
 
	private BufferedReader bufferedReader;
	private String[] line;
	private int lineIndex;
	private char delimetr;
	private boolean isClosed;
 
	public MyScanner2(Reader reader) {
		this.bufferedReader = new BufferedReader(reader);
		delimetr = ' ';
		isClosed = false;
	}
 
	public String next() {
		checkIfIsClosed();
		readLine();
		return line[lineIndex++];
	}
 
	public int nextInt() {
		checkIfIsClosed();
		String next = next();
 
		try {
			return Integer.parseInt(next);
		} catch (Exception ex) {
			throw new InputMismatchException();
		}
	}
 
	public String nextLine() {
		checkIfIsClosed();
		readLine();
		String result = "";
		for (int i = lineIndex; i < line.length; i++) {
			result += delimetr + line[i];
		}
		return result;
	}
 
	public boolean hasNext() {
		checkIfIsClosed();
		readLine();
		return lineIndex < line.length;
	}
 
	public boolean hasNextInt() {
		checkIfIsClosed();
		readLine();
		if (lineIndex >= line.length) {
			return false;
		}
		try {
			Integer.parseInt(line[lineIndex + 1]);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
 
	public void useDelimiter(char delimiter) {
		checkIfIsClosed();
		this.delimetr = delimiter;
	}
 
	public void close() {
		isClosed = true;
	}
 
	private void readLine() {
		if (line == null) {
 
			try {
				String readLine = bufferedReader.readLine();
				line = readLine.split(Character.toString(delimetr));
				lineIndex = 0;
 
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
 
	private void checkIfIsClosed() {
		if (isClosed) {
			throw new IllegalStateException("Scanner is closed");
		}
	}
}

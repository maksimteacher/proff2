package chat;

import java.io.*;
import java.net.Socket;

public class Client extends Thread {
	public final int PORT = 3043;
	private Socket sock;
	private ClientReader reader;
	private ClientWriter writer;
	private File file;
	private BufferedReader buffRead;

	@Override
	public void run() {
		
		try {
			sock = new Socket("localhost", PORT);
			System.out.println("Created new client");
			file = new File("history.txt");
			reader = new ClientReader(sock, file);
			writer = new ClientWriter(sock);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendNewMessage(String s) {
		writer.sendNewMessage(s);
	}

	public String getHistory() throws IOException {
		String line;
		buffRead = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		while((line = buffRead.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		buffRead.close();
		return sb.toString();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void passTextArea(MyTextArea previousTexts) {
		reader.passTextArea(previousTexts);
		
	}
	
	public void shutDownDaemons() {
		reader.shutDown();
		writer.shutDown();
	}

}

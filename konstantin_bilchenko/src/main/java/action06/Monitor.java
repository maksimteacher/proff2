package action06;

public class Monitor {

	private ThreadCreator creator;
	private ThreadWriter writer;

	public Monitor(String nameFile1, String nameFile2) throws InterruptedException {
		super();
		creator = new ThreadCreator(nameFile1);
		creator.start();
		writer = new ThreadWriter(nameFile2);
		writer.start();
	}

	public ThreadCreator getCreator() {
		return creator;
	}

	public ThreadWriter getWriter() {
		return writer;
	}

}

class ThreadCreator extends Thread {

	private String nameFile;

	public ThreadCreator(String nameFile) {
		super();
		this.setNameFile(nameFile);
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	@Override
	public void run() {
		while (true) {
			if (isInterrupted())
				break;
		}
		System.out.println("done ThreadCreator");
	}

}

class ThreadWriter extends Thread {

	private String nameFile;

	public ThreadWriter(String nameFile) {
		super();
		this.setNameFile(nameFile);
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	@Override
	public void run() {
		
		while (true) {
			if (isInterrupted())
				break;
		}
		System.out.println("done ThreadWriter");
	}

}

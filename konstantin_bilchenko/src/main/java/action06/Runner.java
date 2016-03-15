package action06;

public class Runner {

	public static void main(String[] args) throws InterruptedException {

		Monitor monitor = new Monitor("test1.txt", "test2.txt");
		System.out.println("Start");

		Thread.sleep(2000);

		monitor.getCreator().interrupt();

		Thread.sleep(2000);

		monitor.getWriter().interrupt();
	}
}

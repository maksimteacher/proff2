package tripleton;

public class Client {
	private static int counter = 3;
	private static Client lastClient;
	private int id;
	
	private Client() {
		id = counter--;
	}
	
	public static Client getInstance() {
		if (counter > 0) {
			lastClient = new Client();
		}
		return lastClient;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + "]";
	}
	
	
}

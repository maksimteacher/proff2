package tripleton;

public class Client {
	private static int counter = 3;
	private static Client[] clients;
	private int id;
	
	static {
		clients = new Client[counter];
		for (int i = 0 ; i < counter ; i++) {
			clients[i] = new Client(i);
		}
	}
	
	private Client(int id) {
		this.id = id;
	}
	
	private Client(){}
	
	public static Client getInstance() {
		int n = (int) (Math.random() * counter);
		return clients[n];
	}

	@Override
	public String toString() {
		return "Client [id=" + id + "]";
	}

	public int getId() {
		return id;
	}
	
	
}

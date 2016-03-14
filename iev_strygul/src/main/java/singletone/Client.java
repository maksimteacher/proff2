package singleton;

public class Client {
	private static Client[] count = new Client[3];
	private static int i = 0;
	
	private Client() {
	}
	
	public static Client createClient() {
		if(count[0] == null) {
			return count[0] = new Client();
		} else if(count[1] == null) {
			return count[1] = new Client();
		} else if(count[2] == null) {
			return count[2] = new Client();
		} else {
			if(i <= 2) {
				return count[i++];
			} else {
				i = 0;
				return count[i++];
			}
		}
	}
}

package tripleton;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		List<Client> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(Client.getInstance());
		}
		for (Client client : list) {
			System.out.println(client);
		}
		
	}

}

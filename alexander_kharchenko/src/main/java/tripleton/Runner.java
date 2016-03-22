package tripleton;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		List<Client> list = new ArrayList<>();
		for (int i = 0; i < 150; i++) {
			list.add(Client.getInstance());
		}
		int [] frequency = new int[3];
		for (Client client : list) {
			System.out.println(client);
			frequency[client.getId()]++;
		}
		for (int i : frequency) {
			System.out.print(i + " ");
		}
		
	}

}

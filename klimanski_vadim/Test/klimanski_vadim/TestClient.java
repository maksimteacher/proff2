package klimanski_vadim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Action5.Client;

public class TestClient {
	private Client client;
	
	
	@Before
	public void before(){
		client = Client.getClientInstanse();
			}
	
	Client client2 = Client.getClientInstanse();
	Client client3 = Client.getClientInstanse();
	
	
	@Test
	public void asserTrue() {
		
		assertTrue(client2!=client3);
		assertTrue(client!=client3);
		assertTrue(client!=client2);
		
		Client client4 = Client.getClientInstanse();
		
		//assertTrue(client4==client3||client4==client2||client4==client);
	}

	

}

package singleton;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tripletone.Client;

public class TestClient {
	
	Client client1;
	Client client2;
	Client client3;
	Client client4;
	Client client5;
	Client client6;
	Client client7;
	
	@Before
	public void init() {
		client1 = Client.createClient();
		client2 = Client.createClient();
		client3 = Client.createClient();
		client4 = Client.createClient();
		client5 = Client.createClient();
		client6 = Client.createClient();
		client7 = Client.createClient();
	}
	

	@Test
	public void test() {
		assertFalse(client1 == client2);
		assertFalse(client2 == client3);
		assertFalse(client3 == client1);
	}
	
	@Test
	public void test1() {
		assertTrue(client1 == client4);
		assertTrue(client2 == client5);
		assertTrue(client3 == client6);
		assertTrue(client1 == client7);
	}

}

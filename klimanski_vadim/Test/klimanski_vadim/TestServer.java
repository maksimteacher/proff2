package klimanski_vadim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Action5.Server;

public class TestServer {
	
	Server serv = Server.getInst();

	
	@Before
	public void init(){
		
		
	}
	
	
	@Test
	public void test() {
		Server expect = serv;
		Server result = Server.getInst();
	
		assertTrue(expect==result);
		assertTrue(expect!=null);
		
		/*Server serv = new Server();
		Server serv1 = new Server();
		if(serv==serv1)
			System.out.println("равны");
		else{
			System.out.println("Не равны");
		}
		assertEquals(serv, serv1);
		*/
		
		
	}

	
}

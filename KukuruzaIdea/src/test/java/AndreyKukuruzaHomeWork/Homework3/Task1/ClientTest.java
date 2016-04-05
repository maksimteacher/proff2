package AndreyKukuruzaHomeWork.Homework3.Task1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
    @Before
    public void before() {
    }

    @Test
    public void testGetInstance() throws Exception {
        Client client0 = Client.getInstance(0);
        Client client1 = Client.getInstance(1);
        Client client2 = Client.getInstance(2);
        Client client3 = Client.getInstance(0);
        Client client4 = Client.getInstance(1);
        Client client5 = Client.getInstance(2);
        assertEquals(client0, client3);
        assertEquals(client1, client4);
        assertEquals(client2, client5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithEx() throws Exception {
        Client c = Client.getInstance(4);
    }

    @Test
    public void testGet() throws Exception {
        Client c1 = Client.getInstance(1);
        Client c2 = Client.getInstance(2);
        assertNotSame(c1,c2);
    }
}
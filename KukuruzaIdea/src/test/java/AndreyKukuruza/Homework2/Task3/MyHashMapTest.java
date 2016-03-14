package AndreyKukuruza.Homework2.Task3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {
    MyHashMap<String, String> stringStringMyHashMap = new MyHashMap<>();

    @Before
    public void before() {
        for (int i = 0; i < 10000; i++) {
            stringStringMyHashMap.add("key" + i, "value" + i);
        }
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals("add", "value100", stringStringMyHashMap.get("key100"));
        assertEquals("add", "value1000", stringStringMyHashMap.get("key1000"));
        assertNull("add", stringStringMyHashMap.get("ket10000"));
        assertNull("add", stringStringMyHashMap.get("key"));
    }

    @Test
    public void testContains() throws Exception {
        for (int i = 1110; i < 3000; i++) {
            assertTrue("contains", stringStringMyHashMap.contains("key" + i));
        }
    }

    @Test
    public void testSize() throws Exception {
        assertEquals("size", 10000, stringStringMyHashMap.size());
        stringStringMyHashMap.add("unik key", "val");
        assertEquals("size", 10001, stringStringMyHashMap.size());
        stringStringMyHashMap.add("key100", "val");
        assertEquals("size", 10001, stringStringMyHashMap.size());
    }

    @Test
    public void testGet() throws Exception {
        assertEquals("get", "value100", stringStringMyHashMap.get("key100"));
        stringStringMyHashMap.add("key100", "ololo");
        assertEquals("get", "ololo", stringStringMyHashMap.get("key100"));
    }
}
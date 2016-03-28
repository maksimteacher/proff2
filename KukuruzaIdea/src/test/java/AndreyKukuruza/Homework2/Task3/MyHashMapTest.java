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

    @Test
    public void testRemove() throws Exception {
        System.out.println(stringStringMyHashMap.size());
        stringStringMyHashMap.remove("key255");
        stringStringMyHashMap.remove("key555");
        System.out.println(stringStringMyHashMap.size());
        for (int i = 0; i < 10000; i++) {
            if (i == 255 || i == 555) assertNull(stringStringMyHashMap.get("key255"));
            else
                assertEquals("value" + i, stringStringMyHashMap.get("key" + i));
        }
    }

    @Test
    public void testRemove2() throws Exception {
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0) {
                stringStringMyHashMap.remove("key" + i);
            }
        }
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0) assertNull(i + "", stringStringMyHashMap.get("key" + i));
            else
                assertEquals("value" + i, stringStringMyHashMap.get("key" + i));
        }
    }
}
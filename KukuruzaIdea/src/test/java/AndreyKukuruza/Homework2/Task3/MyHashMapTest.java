package AndreyKukuruza.Homework2.Task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {
    MyHashMap<String, String> stringStringMyHashMap = new MyHashMap<>();

    @Test
    public void testAdd() throws Exception {
        stringStringMyHashMap.add("","");
        stringStringMyHashMap.add("asd","asd");
        stringStringMyHashMap.add("asd","asd");
        stringStringMyHashMap.add("sdf","sdsd");
        stringStringMyHashMap.add("sdf","sdf");
        stringStringMyHashMap.add("asd",null);
        assertEquals("input","",stringStringMyHashMap.get(""));
    }

    @Test
    public void testContains() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }
}
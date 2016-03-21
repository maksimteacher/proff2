package action4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<> ();
		map.put(10, "Car");
		map.put(20, "Book");
		map.put(30, "Car");
		map.put(40, "Book");
		map.put(50, "Car");
		map.put(60, "Book");
		map.put(70, "Car");
		map.put(80, "Book");
		Set<Map.Entry<Integer,String>> set = map.entrySet();
		for(Map.Entry<Integer, String> entry : set){
			System.out.println("["+entry.getValue());
		}
	}
}


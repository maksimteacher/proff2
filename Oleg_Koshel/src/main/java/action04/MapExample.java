package action04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(10, "Car");
		map.put(20, "Book");
		Set<Map.Entry<Integer,String>> set = map.entrySet();
		for(Map.Entry<Integer, String> entry : set){
			System.out.println("["+entry.getKey() +","+entry.getValue()+"]");
		}
	}
}

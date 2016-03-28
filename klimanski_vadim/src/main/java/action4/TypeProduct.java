package action4;

public enum TypeProduct {
	Bread, Yogurt, Milk;
	
	public static void main(String[] args) {
		TypeProduct obj1 = TypeProduct.Milk;
		TypeProduct obj2 = TypeProduct.Bread;
		if(obj1==obj2)System.out.println("СЂР°РІРЅС‹");
		String str = obj1.toString();// "Milk"
		TypeProduct obj3 = TypeProduct.valueOf(str);
		TypeProduct[] arr = TypeProduct.values();
		TypeProduct obj4 = TypeProduct.values()[0];
		System.out.println(obj1.name());
	}
/*
public class MapExample {
	
		Map<Integer, String> map = new HashMap<> ();
		map.put(10, "Car");
		map.put(20, "Book");
		Set<Map.Entry<Integer,String>> set = map.entrySet();
		for(Map.Entry<Integer, String> entry : set){
			System.out.println("["+entry.getKey() +","+entry.getValue()+"]");
		}
	}
}*/
}
package action02;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListExample {
	public static void main(String[] args) {
		
		//ArrayList<Car> list = new ArrayList<>();
		HashSet<Car> list = new HashSet<>();
		list.add(new Car("AA 111","black"));
		list.add(new Car("EE 222","black"));
		list.add(new Car("CC 33","red"));
		list.add(new Car("DD 444","white"));
		System.out.println("boolean="+list.contains(new Car("AA 111","black")));
		System.out.println(new Car("AA 111","black").equals(new Car("AA 111","black")));
	}
}

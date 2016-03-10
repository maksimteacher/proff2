package action02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Task1 {
	public static void main(String[] args) {
		Set<Car> set = new HashSet<>();
		set.add(new Car("AA 111","black"));
		set.add(new Car("EE 222","black"));
		set.add(new Car("CC 33","red"));
		set.add(new Car("DD 444","white"));
		for(Car car:set){
			
		}
		System.out.println("contains="+set.contains(new Car("AA 111","black")));
		Iterator<Car> iter = set.iterator();
		while(iter.hasNext()){
			Car car = iter.next();
			//if(car.getColor().equals("red"))iter.remove();
			if(car.getColor().equals("red"))car.setColor("grey");
		}
		iter = set.iterator();
		while(iter.hasNext()){
			Car car = iter.next();
			iter.remove();
			System.out.println(car);
		}
		set.forEach(new Consumer<Car>(){
			@Override
			public void accept(Car temp) {
				temp.setColor(temp.getColor()+"1");				
			}			
		});
		
		set.forEach(temp1->temp1.setColor(temp1.getColor()+"2"));
		
		System.out.println();
		iter = set.iterator();
		while(iter.hasNext()){
			Car car = iter.next();
			System.out.println(car);
		}
	}
}

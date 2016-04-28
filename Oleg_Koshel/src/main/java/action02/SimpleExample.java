package action02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class SimpleExample {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList();
		
		for(int i=0;i<30;i++){
			list.add((int)(100*Math.random()));
		}
		list.forEach(new Consumer<Integer>(){
			@Override
			public void accept(Integer t) {
				System.out.print(t+",");				
			}			
		});
		System.out.println(list);
		
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){				
			if(isSimple(iter.next())) iter.remove();
		}
		System.out.println();
		list.forEach(number->System.out.print(number+", "));
	}
	public static boolean isSimple(int k){
		if(k<=3) return true;
		for(int i = 2; i<k/2;i++){
			if(k%i==0) return false;
		}
		return true;
	}
}

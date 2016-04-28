package action02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PrimeNumberRemoving {

	public static void main(String[] args) {
		List<Integer> numberList = new ArrayList<>(1000);
		for (int i = 0; i < 1001; i++){
			numberList.add((int)(100*Math.random()));
			}
		System.out.println(Arrays.asList(numberList));
		Iterator<Integer> iterator = numberList.iterator();
		while (iterator.hasNext()) {
			if (isPrime(iterator.next())) iterator.remove();
		}
		System.out.print(numberList);
		}
	public static boolean isPrime(int checkNumber) {
		int dividerCount = 0;
		for (int i = 1; i < checkNumber+1 ; i++){
			if ((checkNumber % i) == 0) dividerCount++;
		}
		if (dividerCount < 3) {
			return true;
		} else { return false;}
	}
	
}

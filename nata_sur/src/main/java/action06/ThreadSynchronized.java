package action06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSynchronized {

}
class MyThread4{
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
	
		List<Integer> list1 = Collections.synchronizedList(list);
	}
	
}

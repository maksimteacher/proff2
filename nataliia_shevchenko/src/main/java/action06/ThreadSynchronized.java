package action06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Example

public class ThreadSynchronized {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		List<Integer> list1= (List<Integer>) Collections.synchronizedCollection(list);
		//List<Integer> list1= Collections.synchronizedCollection(list);
	}

}

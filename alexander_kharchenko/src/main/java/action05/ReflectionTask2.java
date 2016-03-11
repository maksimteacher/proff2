package action05;

import java.io.Serializable;
import java.util.Iterator;

public class ReflectionTask2 {

	public static void main(String[] args) {
		C<Integer> c = new C<>();
		
		ReflectionTask1.foo(c, true);
		System.out.println();
		ReflectionTask1.foo(new Integer(3), true);
	}

}

class A implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
class B extends A implements Serializable, Cloneable {
	
}

class C<E> extends B implements Cloneable, Iterable<C> {
	private E value;
	
	@Override
	public Iterator<C> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


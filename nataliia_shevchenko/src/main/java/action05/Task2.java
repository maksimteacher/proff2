package action05;

import java.util.Iterator;

import javassist.tools.reflect.Reflection;

public class Task2 {
	public static void main(String[] args) {
		C c = new C();

		Task1.method(c);
		System.out.println();
		B b = new B();
		Task1.method(b);
		
	}

}

class A implements Runnable {

	@Override
	public void run() {

	}
}

class B extends A implements Cloneable {

}

class C extends B implements Iterable {

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
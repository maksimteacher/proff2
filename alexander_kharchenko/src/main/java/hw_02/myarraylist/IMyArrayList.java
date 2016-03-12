package hw_02.myarraylist;

import java.util.Iterator;
import java.util.function.Consumer;

public interface IMyArrayList<E> {
	 void add(E element);
	 void add(int index, E element);
	 E get(int index);
	 int size();
//	 void forEach(Consumer<E> c);
	 E[] toArray();
	 void sort();
	Iterator<E> iterator();
	
}

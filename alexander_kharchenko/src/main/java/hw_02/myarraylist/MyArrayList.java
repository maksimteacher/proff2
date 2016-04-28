package hw_02.myarraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyArrayList<E> implements IMyArrayList<E>{
	private static final int DEFAULT_CAPACITY = 3;
	private Object[] array;
	private int size;
	
	public MyArrayList() {
		array = new Object[DEFAULT_CAPACITY];
	}
	
	public MyArrayList(int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException();
		}
		array = new Object[capacity];
	}

	@Override
	public void add(E element) {
		add(size, element);
		
	}

	@Override
	public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException();	
		}
		if (size == array.length) {
			resize(index);
		} else if (index < array.length) {
			System.arraycopy(array, index, array, index + 1, size - index);
		}
		array[index] = element;
		size++;
	}

	private void resize(int index) {
		System.out.println("resize");
		System.out.println(Arrays.toString(array));
		Object[] newArray = new Object[array.length * 3 / 2 + 1];
		if (index == array.length) {
			System.arraycopy(array, 0, newArray, 0, array.length);
		} else {
			System.arraycopy(array, 0, newArray, 0, index);
			System.arraycopy(array, index, newArray, index + 1, array.length - index);
		}
		
		array = newArray;
		System.out.println(Arrays.toString(array));
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		return (E) array[index];
	}

	@Override
	public int size() {
		return size;
	}
	
//	@Override
	public void forEach1(Consumer<E> c) {
		System.out.println("for each implementation...");
		for (int i = 0 ; i < size ; i++) {
			c.accept((E) array[i]);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		Object[] a = new Object[size];
		System.arraycopy(array, 0, a, 0, size);
		return (E[]) a;
	}

	@Override
	public void sort() {
		Object[] toSort = new Object[size];
		System.arraycopy(array, 0, toSort, 0, size);
		Arrays.sort(toSort);
//		System.out.println(Arrays.toString(toSort));
		System.arraycopy(toSort, 0, array, 0, size);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0 ; i < size ; i++) {
			sb.append(array[i]);
			if (i != size - 1) {
				sb.append(", ");
			}
		}
		sb.append("]; size=").append(size);
		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Itr();
	}

	class Itr implements Iterator<E>{
		private int index;
		
		Itr() {
			index = 0;
		}
		
		@Override
		public boolean hasNext() {
			
			return (size - index) > 0;
		}

		@Override
		public E next() {
			if (index >= size) {
				throw new NoSuchElementException();
			}
			return (E) array[index++];
		}
		
	}
	
}


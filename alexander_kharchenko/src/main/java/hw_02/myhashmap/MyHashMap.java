package hw_02.myhashmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHashMap<K, V> implements Iterable<K> {
	private MyEntry<K, V>[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public MyHashMap() {
		array = new MyEntry[16];
	}

	public void put(K key, V element) {
		
		if (contains(key)) {
			System.out.println("key " + key + " is already in this map");
			return;
		}
		
		int index = index(key);

		if (size >= array.length * 2) {
			resize();
		}
		MyEntry<K, V> node = new MyEntry<>();
		node.value = element;
		node.key = key;
		if (array[index] == null) {
			array[index] = node;
		} else {
			MyEntry<K, V> n = null;
			for (n = (MyEntry<K, V>) array[index]; n.next != null; n = n.next) {
				// System.out.println(n);
			}
			n.next = node;
		}
		// node.next = new Node();
		size++;
		System.out.println(toString());
	}

	private int index(K key) {
		return key.hashCode() % (array.length);
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		System.out.println("...RESIZE...");
		List<MyEntry<K, V>> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			for (MyEntry<K, V> node = (MyEntry<K, V>) array[i]; node != null; node = node.next) {
				list.add(node);
			}
		}
		// System.out.println(list);
		array = new MyEntry[array.length * 2];
		size = 0;
		for (MyEntry<K, V> o : list) {
			put(o.key, o.value);
		}
		System.out.println("...END...");
	}

	public int size() {
		return size;
	}

	public boolean contains(K key) {
		int i = index(key);
		for (MyEntry<K, V> node = (MyEntry<K, V>) array[i]; node != null; node = node.next) {
			if (node.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	private static class MyEntry<K, V> {
		V value;
		K key;
		MyEntry<K, V> next;

	}

	private class Itr<K, V> implements Iterator<K> {
		private int index = -1;
		private MyEntry<K, V> pointer;
		private int counter;

		@Override
		public boolean hasNext() {
			return (counter < size);
		}

//		@SuppressWarnings("unchecked")
		@Override
		public K next() {
			if (pointer == null || pointer.next == null) {
				while (array[++index] == null);
				pointer = (MyEntry<K, V>) array[index];
			} else {
				pointer = pointer.next;
			} 
			counter++;
			return (K) pointer.key;
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Size: ");
		sb.append(size).append(" [");
		int maxDepth = 0;
		for (int i = 0; i < array.length; i++) {
			sb.append(i);
			sb.append(":{");
			int depth = 0;
			for (MyEntry<K, V> node = (MyEntry<K, V>) array[i]; node != null; node = node.next) {
				sb.append("<").append(node.key).append(":").append(node.value).append(">");
				if (node.next != null) {
					sb.append(", ");
				}
				depth++;

			}
			sb.append("}");
			if (i != array.length - 1) {
				sb.append(", ");
			}
			if (maxDepth < depth) {
				maxDepth = depth;
			}
		}
		sb.append("] max depth= ").append(maxDepth);
		return sb.toString();
	}

	@Override
	public Iterator<K> iterator() {
		return new Itr<K, V>();
	}

	public void clear() {
		array = new MyEntry[array.length];
		size = 0;
		
	}
}

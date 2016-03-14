package hw_02.myhashset;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet<E> {
	private Node<E>[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyHashSet() {
		array = new Node[3];
	}
	
	public void add(E element) {
		int index = index(element);
		
//		System.out.println(index);
		if (contains(element)) {
			System.out.println("set contains " + element);
			return;
		}
		if (size >= array.length * 2) {
			resize();
		}
		Node<E> node = new Node<>();
		node.value = element;
		if (array[index] == null) {
			array[index] = node;
		} else {
			Node<E> n = null;
			for (n = (Node<E>) array[index] ; n.next != null ; n = n.next) {
//				System.out.println(n);
			}
			n.next = node;
		}
//		node.next = new Node();
		size++;
		System.out.println(toString());
	}
	
	private int index(E element) {
		return element.hashCode() % (array.length);
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		System.out.println("...RESIZE...");
		List<E> list = new ArrayList<>();
		for (int i = 0 ; i < array.length ; i++) {
			for (Node<E> node = (Node<E>) array[i] ; node != null ; node = node.next) {
				list.add(node.value);
			}
		}
//		System.out.println(list);
		array = new Node[array.length * 2];
		size = 0;
		for (E o : list) {
			add(o);
		}
		System.out.println(toString());
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(E element) {
		int i = index(element);
			for (Node<E> node = (Node<E>) array[i] ; node != null ; node = node.next) {
				if (node.value.equals(element)) {
					return true;
				}
			}
		
		return false;
	}
	
	private static class Node<E> {
		E value;
		Node<E> next;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Size: ");
		sb.append(size).append(" [");
		for (int i = 0 ; i < array.length ; i++) {
			sb.append(i);
			sb.append(":{");
			for (Node<E> node = (Node<E>) array[i] ; node != null ; node = node.next) {
				sb.append("<").append(node.value).append(">");
				if (node.next != null) {
					sb.append(", ");
				}
			}
			sb.append("}");
			if (i != array.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}


package homeworkArrayVSLinkedLists;

public class LinkedList<E> extends AbstractList<E> implements List<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private int size;

	private Node<E> first;
	private Node<E> last;
	@SuppressWarnings("unused")
	private E[] data;

//	public LinkedList() {
//
//	}
	public LinkedList() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public LinkedList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	// называется конструктор копий:
	public LinkedList(List<? extends E> list) {
		super(list);
	}

	@Override
	public void add(int idx, E element) {
		
		if (idx != size){
			checkIdx(idx);
		}
		if (size == 0) { //вставка в пустой список
			Node<E> node = new Node<>(element, null, null);
			first = last = node;
		} else if (idx == 0) {//вставка в начало, если список не пустой
			Node<E> node = new Node<>(element, first, null);
			first.prev = node;
			first = node;
		} else if (idx == size) {//вставка в конец, если есть элементы
			Node<E> node = new Node<>(element, null, last);
			last.next = node;
			last = node;
		} else { //по произвольному индексу
			Node<E> node = findNodeByIdx(idx);
			Node<E> newNode = new Node<>(element, node, node.prev);
			node.prev.next = newNode;
			node.prev = newNode;		}
		size++;
	}

	@Override
	public E get(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int idx, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addAll(List<? extends E> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int idx, List<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}
	
	private Node<E> findNodeByIdx(int idx){
		checkIdx(idx);
		//добавить поиск с конца
		Node<E> tmp = first;
		for (int i = 0; i < idx; i++) {
			tmp = tmp.next;			
		}
		return tmp;
	}
	
	
	@Override
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		for (Node<E> tmp = first; tmp != null; tmp = tmp.next) {
			if (tmp.next != null) {
				sb.append(tmp.elem).append(", ");
			} else {
				sb.append(tmp.elem).append("]");
			}
		}
//		sb.append(System.lineSeparator()).append("[");
//		for (Node<E> tmp = last; tmp != null; tmp = tmp.prev) {
//				if (tmp.prev != null) {
//					sb.append(tmp.elem).append(", ");
//				} else {
//					sb.append(tmp.elem).append("]");
//				}
//		}
		return sb.toString();
	}

	private static class Node<T> {
		T elem;
		Node<T> next;
		Node<T> prev;

		public Node(T elem, Node<T> next, Node<T> prev) {
			this.elem = elem;
			this.next = next;
			this.prev = prev;
		}
	}
	

	@Override
	public List<E> sublist(int fromIdx, int toIdx) {
		// TODO Auto-generated method stub
		return null;
	}

}

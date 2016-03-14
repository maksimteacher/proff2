package homeworkArrayVSLinkedLists;

public class ArrayList<E> extends AbstractList<E> implements List<E> {
	private static final int DEFAULT_CAPACITY = 10;

	private E[] data;
	private int size;

	// ����� ���� ��� ������������
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	public ArrayList(List<? extends E> list) {// �����������, ��� ������� ��� ������������ ������
		this(list.size());
		addAll(list);
	}

	@Override
	public void add(int idx, E element) {
		if (idx != size) {
			checkIdx(idx);
		}
		checkRange();
		// ���������� ���������� � ����� � ��� ����������
		if (idx == size) {
			data[idx] = element;
		} else {
			System.arraycopy(data, idx, data, idx + 1, size - idx);
			data[idx] = element;
		}
		size++;
	}

	@Override
	public E get(int idx) {
		checkIdx(idx);
		return data[idx];
	}

	@Override
	public E set(int idx, E element) {
		checkIdx(idx);
		E oldElem = data[idx];
		data[idx] = element;
		return oldElem;
	}

	@Override
	public E remove(int idx) { // ��� ����� add (�� �������) ��������
		checkIdx(idx);
		E temp = data[idx];
		if (idx != size - 1) {
			System.arraycopy(data, idx + 1, data, idx, size - idx - 1);
		}
		data[--size] = null;
		return temp;
	}

	@Override
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (data[i] == null) {
					return i;
				}
			}
			return -1;
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(data[i])) {
					return i;
				}
			}
			return -1;
		}
	}

	@Override
	public int lastIndexOf(Object o) {
		// ������� ����� ��� � IndexOf
		return 0;
	}

	
	@Override
	public List<E> sublist(int fromIdx, int toIdx) {
		ArrayList<E> subList = new ArrayList<>(toIdx - fromIdx);
		for (int i = fromIdx; i < toIdx; i++) {
			subList.add(data[i]);
		}
		return subList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		data = (E[]) new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	@Override
	public boolean addAll(List<? extends E> list) {
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
		return list.size() > 0;
	}

	@Override
	public boolean addAll(int idx, List<? extends E> c) {
		for (int i = 0; i < c.size(); i++) {
			add(i + idx, c.get(i));
		}
		return c.size() > 0;
	}

	@Override
	public int size() {
		return size;
	}

	// private void checkIdx(int idx){
	// if(idx < 0 || idx >= size){
	// throw new IndexOutOfBoundsException("idx = " + idx + ", size = " + size);
	// //throw new IndexOutOfBoundsException(idx > 0 ? "������1" :
	// "������2");//������ � �������������� ���������� ���������
	// }
	// }

	@SuppressWarnings("unchecked")
	private void checkRange() {
		if (size == data.length) {
			E[] newArr = (E[]) new Object[data.length * 3 / 2 + 1]; 
		    // ��� ������� ����� ������ ����������� � 1,5 ����																	
			// for (int i = 0; i < data.length; i++) {
			// newArr[i] = data[i];
			// }
			// � jdk ���� ������ ������ ���������� �������, �������� �� ����,
			// ��� ������ � ������ �� ��������������
			// ����� ������ ����� ����� ������ � ������� ��������� ������ �
			// ����������� � ������ �����:
			System.arraycopy(data, 0, newArr, 0, data.length);
			// �� ������� data � ������� 0, �������� � ����� newArr c �������
			// �������, �������� �� ����� ������ ������� data.length
			data = newArr;
		}
	}

	@Override
	public String toString() { // �������� ��� ����������� � ����������� �����
		if (size == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			if (i != size - 1) {
				sb.append(data[i]).append(", ");
			} else {
				sb.append(data[i]).append("]");
			}
		}
		return sb.toString();
	}

	

}

package homeworkArrayVSLinkedLists;

public class ArrayList<E> extends AbstractList<E> implements List<E> {
	private static final int DEFAULT_CAPACITY = 10;

	private E[] data;
	private int size;

	// далее идут три конструктора
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	public ArrayList(List<? extends E> list) {// конструктор, так сказать для клонирования листов
		this(list.size());
		addAll(list);
	}

	@Override
	public void add(int idx, E element) {
		if (idx != size) {
			checkIdx(idx);
		}
		checkRange();
		// реализация добавления в конец и без увеличения
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
	public E remove(int idx) { // это метод add (по индексу) наоборот
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
		// сделать также как в IndexOf
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
	// //throw new IndexOutOfBoundsException(idx > 0 ? "ошибка1" :
	// "ошибка2");//запись с использованием тернарного оператора
	// }
	// }

	@SuppressWarnings("unchecked")
	private void checkRange() {
		if (size == data.length) {
			E[] newArr = (E[]) new Object[data.length * 3 / 2 + 1]; 
		    // тут создаем новый массив увеличенный в 1,5 раза																	
			// for (int i = 0; i < data.length; i++) {
			// newArr[i] = data[i];
			// }
			// в jdk есть другой способ копировать массивы, учитывая то факт,
			// что массив в памяти не фрагментирован
			// можно просто взять кусок памяти в которой находится массив и
			// скопировать в другое место:
			System.arraycopy(data, 0, newArr, 0, data.length);
			// из массива data с позиции 0, копируем в масив newArr c нулевой
			// позиции, копируем до конца длинны массива data.length
			data = newArr;
		}
	}

	@Override
	public String toString() { // дописать или скопировать с предыдущего урока
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

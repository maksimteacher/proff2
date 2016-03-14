package homeworkArrayVSLinkedLists;

public abstract class AbstractList<E> implements List<E> {
	// ��� ��������� �����������
	public AbstractList() {

		}

	// ��� ����������� �����
	public AbstractList(List<? extends E> list) {
			addAll(list);
		}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void add(E element) {
		add(size(), element);

	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	protected void checkIdx(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("idx = " + idx + ", size = " + size());
			// throw new IndexOutOfBoundsException(idx > 0 ? "������1" :
			// "������2");//������ � �������������� ���������� ���������
		}
	}

}

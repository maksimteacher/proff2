package homeworkArrayVSLinkedLists;
//see full realization in the previous version of Eclipse OOP21 Lesson11 
public interface List<E> {
	
	void add(E element); //Element adds in the end of the list. ��� ����� ����������� � ����������� ������	 
	void add(int idx, E element);//Inserts the element at the specified index 
	E get(int idx);//returns the element at the specified index
	E set(int idx, E element);//replaces the element at the specified index
	E remove(int idx); //removes element at the specified index
	int indexOf(Object o);//returns index of the first occurrence (���������) of the element
	/**
     * ���������� ������ ���������� ��������� �������� � ������ ���� -1 - ���� ������ �������� � ������ ���,
     * (��� �������� ������������ ����� equals), ������� ������� ����� ���� null
     * @param o ������� �������, ����� ���� null
     * @return ������ ������� ��������� �������� � ������ ���� -1 - ���� ������ �������� � ������ ���
     */    
	int lastIndexOf(Object o);	
	boolean contains(Object o);//���������� true, ���� ���� ������ �������� ������� �������
	List<E> sublist(int fromIdx, int toIdx);//���������� ������ ���������� ���������� �������
	void clear();//������� ��� �������� � ������
	boolean addAll(List<? extends E> list);//��������� ��� �������� � ����� ����� ������ �� ����������� ������
	boolean addAll(int idx, List<? extends E> c);//��������� ��� �������� � ���� ������ �� ����������� ������ �� ���������� �������
	int size();//���������� ���������� ��������� � ���� ������
	boolean isEmpty();//���������� true ���� � ���� ������ ��� ���������
	

}

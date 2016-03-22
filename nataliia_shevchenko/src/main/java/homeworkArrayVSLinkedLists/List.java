package homeworkArrayVSLinkedLists;
//see full realization in the previous version of Eclipse OOP21 Lesson11 
public interface List<E> {
	
	void add(E element); //Element adds in the end of the list. это можно реализовать в абстрактном классе	 
	void add(int idx, E element);//Inserts the element at the specified index 
	E get(int idx);//returns the element at the specified index
	E set(int idx, E element);//replaces the element at the specified index
	E remove(int idx); //removes element at the specified index
	int indexOf(Object o);//returns index of the first occurrence (вхождения) of the element
	/**
     * Возвращает индекс последнего вхождения элемента в списке либо -1 - если такого элемента в списке нет,
     * (Для равнения использовать метод equals), искомый элемент может быть null
     * @param o искомый элемент, может быть null
     * @return индекс первого вхождения элемента в списке либо -1 - если такого элемента в списке нет
     */    
	int lastIndexOf(Object o);	
	boolean contains(Object o);//Возвращает true, если этот список содержит искомый элемент
	List<E> sublist(int fromIdx, int toIdx);//Возвращает список являющийся подсписком данного
	void clear();//Удаляет все элементы в списке
	boolean addAll(List<? extends E> list);//Добавляет все элементы в конец этого списка из переданного списка
	boolean addAll(int idx, List<? extends E> c);//Вставляет все элементы в этот список из переданного списка по указанному индексу
	int size();//Возвращает количество элементов в этом списке
	boolean isEmpty();//Возвращает true если в этом списке нет элементов
	

}

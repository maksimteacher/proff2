package AndreyKukuruzaHomeWork.Homework1.Task3;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] arr;
    private int cursor = 0;

    public MyArrayList() {
        arr = new Object[10];
    }

    public MyArrayList(int capasity) {
        arr = new Object[capasity];
    }


    public void add(T element) {
        ensureCapacity();
        arr[cursor++] = element;
    }

    private void ensureCapacity() {
        if (cursor + 1 > arr.length) {
            Object[] tmp = new Object[arr.length];
            System.arraycopy(arr, 0, tmp, 0, arr.length);
            arr = new Object[cursor * 3 / 2 + 1];
            System.arraycopy(tmp, 0, arr, 0, tmp.length);
        }
    }

    public void add(T element, int index) throws Exception {
        if (index < 0 || index > cursor++) throw new Exception("Вихід за границі");
        ensureCapacity();
        System.arraycopy(arr, index, arr, index + 1, cursor - index + 1);
        arr[index] = element;
    }

    public T get(int index) throws Exception {
        if (index < 0 || index > cursor) throw new Exception("Вихід за границі");
        return (T) arr[index];
    }

    public int size() {
        return cursor;
    }

    public void forEach() {

    }

    public void sort() {
        Arrays.sort(arr, 0, cursor   );
    }
}

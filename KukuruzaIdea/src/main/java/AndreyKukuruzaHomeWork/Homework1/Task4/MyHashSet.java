package AndreyKukuruzaHomeWork.Homework1.Task4;

public class MyHashSet<T> {
    private Node<T>[] backets;
    private int size = 0;

    public MyHashSet() {
        backets = (Node<T>[]) new Node[10];
    }

    public void add(T t) {
        if (this.contains(t)) return;
        int bucketNumber = ((t.hashCode() > 0) ? t.hashCode() : -t.hashCode()) % 10;
        Node<T> node = backets[bucketNumber];
        Node<T> nextNode;
        if (node == null) {
            backets[bucketNumber] = new Node<>(t);
            size++;
            return;
        }
        while (true) {
            nextNode = node.next;
            if (nextNode == null) {
                node.next = new Node<>(t);
                size++;
                return;
            }
            node = nextNode;
        }
    }

    public boolean contains(T t) {
        for (Node<T> backet : backets) {
            Node<T> node = backet;
            if (node == null) continue;
            while (node != null) {
                if (backet.value.equals(t)) return true;
                node = node.next;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    private class Node<T> {

        Node(T value) {
            this.value = value;
        }

        Node<T> next;
        T value;
    }
}

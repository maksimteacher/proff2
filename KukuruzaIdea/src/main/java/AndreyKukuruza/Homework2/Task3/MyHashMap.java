package AndreyKukuruza.Homework2.Task3;

public class MyHashMap<K, V> {
    private Node<K>[] backets;
    private int size = 0;

    public MyHashMap() {
        backets = (Node<K>[]) new Node[10];
    }

    public void add(K k) {
        if (this.contains(k)) return;
        int bucketNumber = ((k.hashCode() > 0) ? k.hashCode() : -k.hashCode()) % 10;
        Node<K> node = backets[bucketNumber];
        Node<K> nextNode;
        if (node == null) {
            backets[bucketNumber] = new Node<>(k);
            size++;
            return;
        }
        while (true) {
            nextNode = node.next;
            if (nextNode == null) {
                node.next = new Node<>(k);
                size++;
                return;
            }
            node = nextNode;
        }
    }

    public boolean contains(K k) {
        for (Node<K> backet : backets) {
            Node<K> node = backet;
            if (node == null) continue;
            while (node != null) {
                if (backet.value.equals(k)) return true;
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

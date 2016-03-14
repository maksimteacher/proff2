package AndreyKukuruza.Homework2.Task3;

public class MyHashMap<K, V> {
    private Entry<K, V>[] backets;
    private int size = 0;

    public MyHashMap() {
        backets = (Entry<K, V>[]) new Entry[10];
    }

    public void add(K k, V v) {
        for (Entry<K, V> backet : backets) {
            Entry<K, V> node = backet;
            if (node == null) continue;
            while (node != null) {
                if (backet.key.equals(k)) {
                    backet.value = v;
                    break;
                }
                node = node.next;
            }
        }
        int bucketNumber = ((k.hashCode() > 0) ? k.hashCode() : -k.hashCode()) % 10;
        Entry<K, V> node = backets[bucketNumber];
        Entry<K, V> nextNode;
        if (node == null) {
            backets[bucketNumber] = new Entry<>(k, v);
            size++;
            return;
        }
        while (true) {
            nextNode = node.next;
            if (nextNode == null) {
                node.next = new Entry<>(k, v);
                size++;
                return;
            }
            node = nextNode;
        }
    }

    public boolean contains(K k) {
        for (Entry<K, V> backet : backets) {
            Entry<K, V> node = backet;
            if (node == null) continue;
            while (node != null) {
                if (backet.key.equals(k)) return true;
                node = node.next;
            }
        }
        return false;
    }

    public V get(K k) {
        for (Entry<K, V> backet : backets) {
            Entry<K, V> node = backet;
            if (node == null) continue;
            while (node != null) {
                if (backet.key.equals(k)) return backet.value;
                node = node.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }


    private class Entry<K, V> {
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K key;
        V value;
        Entry<K, V> next;
    }
}

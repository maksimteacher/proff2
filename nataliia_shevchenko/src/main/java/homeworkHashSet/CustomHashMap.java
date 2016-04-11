package homeworkHashSet;
/**
 * One of the common interview question, is to build own CustomHashMap. 
 * Following code sample demonstrate generic map with put(), get() and remove() operations.
 * The CustomHashMap uses an array of KeyValuePair.
 * KeyValuePair class  where K is the key and V value and  next is the element 
 * appended to it. The KeyValuePair acts 
 * as a list
 * 
 *  MapList is used to store elements. the getHash() method is used to find 
 *  the index of the array. 
 * 
 * @param <K>
 * @param <V>
 */
public class CustomHashMap<K, V> {
 
    KeyValuePair<K, V> mapList[] = new KeyValuePair[100];
 
    public V get(K key) {
        int index = getHash(key);
        KeyValuePair<K,V> list = mapList[index];
        return getMatchValue(list, key);
    }
 
    public void put(K key, V value) {
        int index = getHash(key);
        storeValue(index, key, value);
    }
     
    public void remove(K key) {
        int index = getHash(key);
        KeyValuePair<K,V> list = mapList[index];
        if (list == null)
            return;
        // if only one element is present in the list ,set the index to null
        if(list.getKey().equals(key)){
            if (list.next == null){
                mapList[index] = null;
                return;
            }
        }
        KeyValuePair<K,V> prev = null;
        do{
            if(list.key.equals(key)){
                if (prev == null){
                    list = list.getNext();
                }else{
                    prev.next = list.getNext();
                }
                break;
            }
            list = list.next;
        }while(list != null);
         
        mapList[index] = list;
    }
 
    /*
     * find the match value and return , if not found either throw exception or return null.
     */
    private V getMatchValue(KeyValuePair<K, V> list, K key) {
        while (list != null) {
            if (list.getKey().equals(key))
                return list.getValue();
            list = list.next;
        }
        return null;
    }
 
    private void storeValue(int index, K key, V value) {
        KeyValuePair<K, V> list = mapList[index];
         
        // if list is empty , enter as first element
        if (list == null) {
            mapList[index] = new KeyValuePair<K, V>(key, value);
        } else {
            boolean done = false;
            // traverse through list , if a key is found ,replace the value or add it at the end of the list
            while(list.next != null) {
                if (list.getKey().equals(key)) {
                    list.setValue(value);
                    done = true;
                    break;
                } 
                list = list.next;
            }
            // add at the end of the list
            if (!done)
                list.next = new KeyValuePair<K, V>(key, value);
        }
 
    }
     
    private int getHash(K key) {
        int hash = key.hashCode();
        return hash % 100;
    }
     
    public static void main(String args[]) {
        CustomHashMap<Integer, Integer> map = new CustomHashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(201,201);
        System.out.println("get value is " + map.get(1));
        System.out.println("get value is " + map.get(201));
        System.out.println("get value is " + map.get(2));
        map.remove(1);
        System.out.println("After deletion " + map.get(1));
        System.out.println("get value is " + map.get(201));
    }
 
}
 
class KeyValuePair<K, V> {
    K key;
    V value;
    KeyValuePair<K, V> next = null;
 
    public KeyValuePair<K, V> getNext() {
        return next;
    }
 
    public void setNext(KeyValuePair<K, V> next) {
        this.next = next;
    }
 
    public KeyValuePair(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }
 
    public K getKey() {
        return key;
    }
 
    public void setKey(K key) {
        this.key = key;
    }
 
    public V getValue() {
        return value;
    }
 
    public void setValue(V value) {
        this.value = value;
    }
 
}
package Collections_FrmWrk.implementations;

import java.sql.SQLOutput;

public class    CustomHashMap<K, V> {


    private class Entry<K, V> {

        private K key;
        private V value;

        private Entry<K, V> next;

        Entry(K key, V value) {
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

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }

    int maxSize = 10;
    Entry<K, V> entries[];

    public CustomHashMap() {
        entries = new Entry[maxSize];
    }


    public void put(K key, V value) {
        Entry<K, V> newItem = new Entry<>(key, value);
        int hashCode = key.hashCode();
        int index = hashCode % maxSize;
        Entry<K, V> oldItem = entries[Math.abs(index)];
        if (oldItem == null) {
            entries[Math.abs(index)] = newItem;
        } else {
            Entry<K, V> current = oldItem;
            while (current.next != null) {
                if (current.getKey() == key) {
                    current.setValue(value);
                    return;
                }
                current = current.next;
            }
            if (current.getKey() == key) {
                current.setValue(value);
                return;
            }
            current.next = newItem;
        }

    }


    public V get(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % maxSize;
        Entry<K, V> existing = entries[Math.abs(index)];
        if (existing == null) {
            return null;
        }
        while (existing != null) {
            if (existing.getKey() == key) {
                return existing.getValue();
            }
            existing=existing.next;
        }
        return null;

    }


    public  static  void main(String args[]){
        CustomHashMap<String, String> map= new CustomHashMap<>();
        map.put("Vizag", "1");
        map.put("Hyd", "2");
        map.put("Bangalore", "3");
        map.put("Mumbai", "4");

        System.out.println(map.get("Mumbai"));
    }


}

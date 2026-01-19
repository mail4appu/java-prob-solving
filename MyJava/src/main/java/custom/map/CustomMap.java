package custom.map;

public class CustomMap<K, V> {

    int size = 10;

    Entry<K, V>[] entries;

    CustomMap() {
        entries = new Entry[size];
    }


    public void put(K key, V value) {
        Entry<K, V> currentEntry = new Entry<>(key, value);
        int hashCode = key.hashCode();
        int index = hashCode % 10;
        if (entries[index] == null) { // No entry in the array
            entries[index] = currentEntry;
        } else {    //Entry exists
            Entry<K, V> existingEntry = entries[index];
            if (existingEntry.getKey() == key) {
                existingEntry.setValue(value);
                return;
            }

            while (existingEntry.next != null) {  //This is the tric here
                Entry<K, V> nextEntry = existingEntry.next;
                if (nextEntry.getKey() == key) {
                    nextEntry.setValue(value);
                    return;
                }
                existingEntry = existingEntry.next;
            }
            existingEntry.next = currentEntry;
        }

    }


    public V get(K key) {
        int index = key.hashCode() % size;
        Entry<K, V> entry = entries[index];
        if (entry == null) {
            return null;
        } else {
            while (entry != null) {   //This is the tric here
                if (entry.getKey() == key) {
                    return entry.getValue();
                }
                entry = entry.next;
            }
        }
        return null;
    }

}

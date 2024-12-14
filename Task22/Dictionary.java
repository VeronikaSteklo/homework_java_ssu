package Task22;

import java.util.ArrayList;
import java.util.List;

public class Dictionary<K, V> {
    private static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private final List<Entry<K, V>> entries = new ArrayList<>();

    public void put(K key, V value) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        entries.add(new Entry<>(key, value));
    }

    public V get(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        entries.removeIf(entry -> entry.getKey().equals(key));
    }

    public boolean containsKey(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (Entry<K, V> entry : entries) {
            keys.add(entry.getKey());
        }
        return keys;
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (Entry<K, V> entry : entries) {
            values.add(entry.getValue());
        }
        return values;
    }
}

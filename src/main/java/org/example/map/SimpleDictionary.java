package org.example.map;

import java.util.Arrays;

public class SimpleDictionary<K, V> {

    private static int DEFAULT_CAPACITY = 16;
    private Entry<K, V>[] dictionary;

    public SimpleDictionary(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SimpleDictionary(int capacity){
        this.dictionary = new Entry[capacity];
    }

    public V put(K key, V value){
        int hashCode = key.hashCode();
        int index = hashCode % dictionary.length;
        dictionary[index] = new Entry<>(key, value);
        return value;
    }

    public V get(K key){
        int hashCode = key.hashCode();
        int index = hashCode % dictionary.length;
        var entry = dictionary[index];
        if (entry == null) {
            return null;
        }
        return entry.value;
    }


    @Override
    public String toString() {
        return Arrays.toString(dictionary);
    }

    public static class Entry<K, V>{

        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" +value;
        }
    }
}

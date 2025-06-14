package org.example.map;

import java.util.*;

public class Dictionary<K, V> {

    private Node<K, V>[] table;

    public Dictionary(){
        this(16);
    }

    @SuppressWarnings("unchecked")
    public Dictionary(int capacity){
        this.table = new Node[capacity];
    }

    public V put(K key, V value){
        int hash = hash(key);
        int index = index(hash);

        var newNode = new Node<>(hash, key, value);
        var node = table[index];

        // todo: biz qoymoqchi bo'lgan index da node bormi tekshiramiz,
        //  yo'q bo'lsa ushetga yangi node set bo'ladi
        if (node == null){
            table[index] = newNode;
            return null;
        }

        // todo: Agar u yerda node bo'lsa,
        //  uning next i null bolguncha aylanib chiqamiz va nextiga set qilamiz
        Node<K, V> prev = null;
        while (node != null){

            // todo: Ushbu key dagi node bormi yo'qmi tekshirish kerak
            //  agar bo'lsa uning  value siga yangi value set qilamiz

            if (node.hash == newNode.hash && Objects.equals(node.key, newNode.key)){
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            prev = node;
            node = node.next;
        }

        prev.next = newNode;
        return value;
    }

    public V get(K key){
        int hash = hash(key);
        int index = index(hash);
        Node<K, V> node = table[index];

        if (node == null)
            return null;

        while (node != null){
            if (node.hash == hash && Objects.equals(node.key, key))
                return node.value;
            node = node.next;
        }

        return null;
    }

    public Set<Entry<K, V>> entrySet(){
        var entrySet = new HashSet<Entry<K, V>>();
        for (Node<K, V> node:table){
            while (node != null){
                entrySet.add(new Entry<>(node.key, node.value));
                node = node.next;
            }
        }

        return entrySet;
    }

    public int hash(K key){
        return key == null ? 0 : key.hashCode();
    }

    private int index(int hash){
        return hash % table.length;
    }

    private int index(K key){
        return hash(key) % table.length;
    }

    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "{", "}");
        for (Entry<K, V> entry : entrySet()) {
            sj.add(entry.toString());
        }
        return sj.toString();
    }

    public record Entry<K, V>(K key, V value){

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private static class Node<K, V> {
        int hash;
        K key;
        V value;

        Node<K, V> next;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

}

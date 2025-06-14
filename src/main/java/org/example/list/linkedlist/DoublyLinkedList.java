package org.example.list.linkedlist;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class DoublyLinkedList<E> implements Iterable<E>{

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private boolean add(E element){
        var l = tail;
        var newNode = new Node<>(element);
        tail = newNode;
        if (l == null){
            head = newNode;
        } else {
            l.next = newNode;
            newNode.prev = l;
        }
        size++;
        return true;
    }

    public E get(int index){
        Objects.checkIndex(index, size);

        if (index == 0){
            return head.element;
        }

        Node<E> current = null;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i <= index; i++) {
                current = current.next;
            }
            return current.element;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current.element;
        }

    }

    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        var current = head;

        while (current != null){
            sj.add(String.valueOf(current.element));
            current = current.next;
        }

        return sj.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        var dll = new DoublyLinkedList<String>();
        dll.add("Java");
        dll.add("C++");
        dll.add("Python");
        dll.add("Go");
        dll.add("Scala");

        System.out.println(dll.get(1));
    }
}

package org.example.list.linkedlist;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class SinglyLinkedList<E> implements Iterable<E>{

    private Node<E> head;
    private int size;

    public boolean add(E e) {
        var newNode = new Node<>(e);
        // todo: Head bormi yo'qmi tekshirish kerak
        if (this.head == null) {
            this.head = newNode;
        } else {

            // todo: Oxirgi elementni topish kerak va uning pointeriga yangi element set qilinadi
            var current = this.head;
            while (current.next != null) {
                current = current.next;
            }

            // todo: yangi element set qilinadi!!!
            current.next = newNode;
        }

        size++;
        return true;
    }

    public int getSize(){
        return size;
    }

    public E get(int index){
        Objects.checkIndex(index, size);
        if (index == 0)
            return head.element;

        var current = this.head;

        for (int i = 1; i <= index; i++) {
            current = current.next;
        }

        return current.element;
    }

    public boolean addAtBeginning(E e){
        var newNode = new Node<>(e);

        if (this.head != null)
            newNode.next = this.head;

        this.head = newNode;
        size++;
        return true;
    }

    public boolean removeFromBeginning(){
        if (this.head == null)
            return false;

        this.head = this.head.next;

        size--;
        return true;
    }

    public E remove(int index){
        Objects.checkIndex(index, size);
        var current = head;
        Node<E> prev = null;
        if (index == 0){
            var element = head.element;
            head = head.next;
            size--;
            return element;
        } else {
            for (int i = 1; i <= index; i++) {
                prev = current;
                current = current.next;
            }
        }

        prev.next = current.next;
        size--;
        return current.element;
    }

    public boolean remove(Object o){
        if (head == null) return false;
        Node<E> prev = null;
        Node<E> current = head;

        while (current != null){
            if (Objects.equals(o, current.element)){
                if (prev == null){
                    head = current.next;
                } else {
                    prev.next = current.next;
                }

                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        var stringJoiner = new StringJoiner(", ", "[", "]");
        var current = this.head;

        while (current != null) {
            stringJoiner.add(String.valueOf(current.element));
            current = current.next;
        }

        return stringJoiner.toString();
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

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
        return iterator;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public static void main(String[] args) {

        /*
        size()
        get(index)
        addAtBeginning()
        remove(index)
        remove(obj)
        removeFromBeginning()
        set(index, element)
        */
        var list = new SinglyLinkedList<String>();
        list.add("Java");
        list.add("Groovy");
        list.add("Python");

//        System.out.println(list.addAtBeginning("C++"));
//        System.out.println(list.removeFromBeginning());

        System.out.println(list.remove(0));
        System.out.println(list);
        System.out.println(list.getSize());

    }
}

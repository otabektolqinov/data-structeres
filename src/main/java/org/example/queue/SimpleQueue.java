package org.example.queue;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleQueue<E> implements Iterable<E>{
    private static int defaultCapacity = 10;
    private Object[] elements;
    private int size = 0;

    public SimpleQueue() {
        this(defaultCapacity);
    }

    public SimpleQueue(int capacity) {
        this.elements = new Object[capacity];
    }

    public boolean enqueue(E o){
        if (isFull())
            return false;
        elements[size++] = o;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        E element = (E) elements[0];
        System.arraycopy(elements, 1, elements, 0, size - 1);
        elements[size-1] = null;
        size--;
        return element;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == elements.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                return (E) elements[i++];
            }
        };
    }

    public static void main(String[] args) {
        var q = new SimpleQueue<Integer>(10);
        q.enqueue(12);
        q.enqueue(22);
        q.enqueue(15);
        q.enqueue(33);

        System.out.println(q);

        System.out.println(q.dequeue());

        System.out.println(q);
    }

}

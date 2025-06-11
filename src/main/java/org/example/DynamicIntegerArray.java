package org.example;

import java.util.Arrays;
import java.util.Objects;

public class DynamicIntegerArray {

    private Integer[] elementData;

    private int size = 0;

    public DynamicIntegerArray() {
        this(10);
    }

    public DynamicIntegerArray(int initialCapacity) {
        this.elementData = new Integer[initialCapacity];
    }

    public boolean add(Integer item){
        if (size == elementData.length) {
            grow();
        }
        elementData[size++] = item;
        return true;
    }

    public Integer get(int index){

        // Objects.checkIndex(index, elementData.length);

        if (index < 0 || index > elementData.length) {
            System.out.println("Index is out bounds of the actual array length");
            return null;
        }
        return elementData[index];
    }

    public Integer remove(int index){
        Objects.checkIndex(index, elementData.length);
        Integer oldValue = elementData[index];

        int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        }
        elementData[newSize] = null;
        size = newSize;
        return oldValue;
    }

    public boolean remove(Integer item){
        int i = 0;

        found: {
            if (item == null) {
                for (; i < size; i++) {
                    if (elementData[i] == null) {
                        break found;
                    }
                }
            } else {
                for (; i < size; i++) {
                    if (item.equals(elementData[i])) {
                        break found;
                    }
                }
            }
            return false;
        }

        remove(i);

        return true;
    }

    private void grow() {
        int newCapacity = elementData.length + elementData.length / 2 + 1;
        elementData = Arrays.copyOf(this.elementData, newCapacity);
        /*System.out.println("Array length: " + this.elementData.length);*/
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size));
    }

    public static void main(String[] args) {
        DynamicIntegerArray array = new DynamicIntegerArray(3);
        array.add(12);
        array.add(13);
        array.add(14);
        array.add(15);
        array.add(16);
        array.add(17);
        array.add(18);
        array.add(null);
        array.add(20);
        array.add(21);
        array.add(22);
        array.add(23);
        array.add(24);

        System.out.println(array);

        System.out.println(array.remove(null));

        System.out.println(array);

    }
}

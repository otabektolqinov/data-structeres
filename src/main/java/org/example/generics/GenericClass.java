package org.example.generics;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class GenericClass<E> { // E bu yerda type parameter
    private Object[] elementsData;

    public GenericClass(){
        this(10);
    }

    public GenericClass(int capacity){
        this.elementsData = new Object[capacity];
    }

    public boolean set(int index, E element){
        Objects.checkIndex(index, elementsData.length);

        elementsData[index] = element;
        return true;
    }

    public E get(int index){
        return (E) elementsData[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(elementsData);
    }
}

class Student{

    private final String id;
    private final String name;

    public Student(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
class GenericClassTest {
    public static void main(String[] args) {
        /*GenericClass<String> languages = new GenericClass<String>(); // String bu yerda type argument hisoblanadi

        languages.set(0, "Java");
        languages.set(1, "Scala");
        languages.set(2, "Python");
        System.out.println(languages.get(1));
        System.out.println(languages);*/

        GenericClass<Student> students = new GenericClass<>();

        students.set(0, new Student(UUID.randomUUID().toString(), "Murod"));
        students.set(1, new Student(UUID.randomUUID().toString(), "Umid"));
        students.set(2, new Student(UUID.randomUUID().toString(), "Bahodir"));

        System.out.println(students);
    }
}

package org.example.generics;

public class GenericMethod {

    public static<T extends Comparable<T>> int compare(T object1, T object2){
        return object1.compareTo(object2);
    }
}

record Employee(String name, Integer age) implements Comparable<Employee>{

    @Override
    public int compareTo(Employee o) {
        return this.age.compareTo(o.age);
    }

}


class GenericMethodTest{
    public static void main(String[] args) {
        int compare = GenericMethod.compare(2, 2);
        System.out.println(compare);

        var employee1 = new Employee("john", 12);
        var employee2 = new Employee("james", 45);

        int compare1 = GenericMethod.compare(employee1, employee2);
        System.out.println(compare1);
    }
}

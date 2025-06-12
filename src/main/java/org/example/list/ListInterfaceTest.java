package org.example.list;

import java.util.List;

public class ListInterfaceTest {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(integers.get(1));
        System.out.println(integers.contains(3));
    }
}

package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 11, 9, 7, 13};

        InsertionSort.sort(nums);

        System.out.println(Arrays.toString(nums));


    }
}
package org.example;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 11, 9, 7, 13};

        System.out.println("before sorting");
        for (int num: nums){
            System.out.print(num + ", ");
        }

        System.out.println();
        BubbleSort.sort(nums);
        System.out.println();

        System.out.println("after sorting");
        for (int num: nums){
            System.out.print(num + ", ");
        }


    }
}
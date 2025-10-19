package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 7, 9, 11, 13};
        int target = 13;

        int result = BinarySearch.binarySearch(nums, target);
        if (result != -1)
            System.out.println("Element is found at index: " + result);
        else
            System.out.println("Element not found");
    }
}
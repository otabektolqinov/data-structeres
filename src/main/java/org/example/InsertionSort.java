package org.example;

public class InsertionSort {
    public static void sort(int[] nums){

        int size = nums.length;

        for (int i = 1; i < size; i++) {
            int key = nums[i];
            int j = i - 1;

            // todo: Main purpose of the while loop is to make space for key
            // todo: after loop stops, index is at the right before the sport for the key
            while (j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }

            // todo: that is why we add 1 for the spot that while finds
            nums[j + 1] = key;
        }
    }
}

package org.example;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = (left + right)/2;
            if (arr[mid] == target){
                return mid;
            } else if (arr[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] nums, int target, int left, int right){
        if (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                return recursiveBinarySearch(nums, target, mid + 1, right);
            } else {
                return recursiveBinarySearch(nums, target, left, mid - 1);
            }
        }
        return -1;
    }
}

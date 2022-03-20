package com.ModifiedBinarySearch;

public class Ceiling {

    public static void main(String[] args) {
        // write your code here
        System.out.println(ceiling(new int[]{1, 3, 5, 6, 7, 8, 9}, 10));


    }

    public static int ceiling(int[] nums, int target) {

        if(target > nums[nums.length-1])
            return -1;

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid])
                end = mid - 1;
            else if (target > nums[mid])
                start = mid + 1;
            else
                return mid;
        }
        return start;
    }
}

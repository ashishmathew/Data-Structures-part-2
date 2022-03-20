package com.ModifiedBinarySearch;

public class Floor {

    public static void main(String[] args) {
        // write your code here
        System.out.println(floor(new int[]{2, 3, 5, 6, 7, 8, 9}, 4));


    }

    public static int floor(int[] nums, int target) {

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
        return end;
    }
}

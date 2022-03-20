package com.ModifiedBinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        // write your code here
        //System.out.println(binarySearch(new int[]{1, 3, 5, 6, 7, 8, 9}, 20));
        //System.out.println(orderAgnosticBS(new int[]{1, 3, 5, 6, 7, 8, 9}, 9));
        System.out.println(orderAgnosticBS(new int[]{9,8,7,6,5,4,3,2,1}, 7));

    }

    public static int binarySearch(int[] nums, int target) {
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
        return -1;
    }

    public static int orderAgnosticBS(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        boolean isAsc = nums[start] < nums[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid])
                return mid;
            if (isAsc) {
                if (target < nums[mid])
                    end = mid - 1;
                else if (target > nums[mid])
                    start = mid + 1;

            } else {
                if (target < nums[mid])
                    start = mid + 1;
                else if (target > nums[mid])
                    end = mid - 1;
            }

        }

        return -1;
    }


}

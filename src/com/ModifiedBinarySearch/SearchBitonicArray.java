package com.ModifiedBinarySearch;

class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        // TODO: Write your code here
        int peak = findPeak(arr);
        int keyIdx = orderAgnosticBS(arr, key, 0,peak);
        if (keyIdx != -1)
            return keyIdx;
        else
            return orderAgnosticBS(arr, key, peak + 1, arr.length-1);

    }

    public static int findPeak(int[] arr) {
        // TODO: Write your code here
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1])
                end = mid;
            else // (arr[mid] < arr[mid + 1])
                start = mid + 1;
        }
        return start; // or return end
    }

    public static int orderAgnosticBS(int[] nums, int target, int start, int end) {

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

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[]{1, 3, 8, 4, 3}, 4));
        System.out.println(SearchBitonicArray.search(new int[]{3, 8, 3, 1}, 8));
        System.out.println(SearchBitonicArray.search(new int[]{1, 3, 8, 12}, 12));
        System.out.println(SearchBitonicArray.search(new int[]{10, 9, 8}, 10));
    }
}

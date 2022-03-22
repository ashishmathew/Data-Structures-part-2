package com.ModifiedBinarySearch;

class SearchRotatedArrayKunal {

    public static int search(int[] arr, int key) {
        // TODO: Write your code here
        int pivot = findPivot(arr);

        if (pivot == -1)
            return binarySearch(arr, key, 0, arr.length - 1);

        if (key == arr[pivot])
            return pivot;

        if (key > arr[0])
            return binarySearch(arr, key, 0, pivot - 1);
        else
            return binarySearch(arr, key, pivot + 1, arr.length - 1);

    }

    public static int findPivot(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            //case1
            if (mid < end && arr[mid] > arr[mid + 1])
                return mid;

            //case2
            if (mid > start && arr[mid] < arr[mid - 1])
                return mid - 1;

            //case3
   /*         if (arr[start] <= arr[mid])
                start = mid + 1;
                //case4
            else
                end = mid - 1;*/
            //if you encounter duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                if(arr[start] > arr[start + 1])
                    return start;

                start++;//skip duplicates

                if(arr[end] < arr[end -1])
                    return end - 1;

                end--; //skip duplicates
            } else if(arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]){
                start = mid +1;
            }else
                end = mid -1;
        }

        return -1;
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {

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


    public static void main(String[] args) {
       // System.out.println(SearchRotatedArrayKunal.search(new int[] { 3,7,3,3,3}, 7));
        System.out.println(SearchRotatedArrayKunal.findPivot(new int[] { 2,2,2,9,2}));

        // System.out.println(SearchRotatedArrayKunal.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
       // System.out.println(findPivot(new int[]{10, 15, 1, 3, 8}));
        //System.out.println(findPivot(new int[]{14, 5, 7, 9, 10, -1, 2}));
    }
}

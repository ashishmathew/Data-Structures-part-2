package com.ModifiedBinarySearch;

class FindRange {

    public static int[] findRange(int[] arr, int key) {
        int[] result = {-1, -1};
        result[0] = searchKey(arr, key, false);//1 go left
        if (result[0] != -1)
            result[1] = searchKey(arr, key, true);//1 go left
        return result;
    }

    // 4 6 6 6 9
    // 0 1 2 3 4
    //         se
    //       m
    //keyidx left 1 3
    public static int searchKey(int[] arr, int key, boolean findMaxIdx) {
        int start = 0;
        int end = arr.length - 1;
        int keyIdx = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid])
                end = mid - 1;
            else if (key > arr[mid])
                start = mid + 1;//1
            else {         //(key == arr[mid])
                keyIdx = mid;//2
                if (findMaxIdx)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return keyIdx;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[]{4, 6, 6, 6, 9}, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[]{1, 3, 8, 10, 15}, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[]{1, 3, 8, 10, 15}, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
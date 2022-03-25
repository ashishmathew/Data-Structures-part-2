package com.topKelements;

import java.util.*;

import java.util.*;

class Entry { // this will be for storing key = distance with X, value = index of the element in the array
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        int index = binarySearch(arr, X);

        //We need have in the K distance range , so look at the below range calculation carefully
        int low = index - K;
        int high = index + K;
        low = Math.max(low, 0);
        high = Math.min(high, arr.length - 1);
        PriorityQueue<Entry> pq = new PriorityQueue<>((n1, n2) -> n1.key - n2.key);
        for (int i = low; i <= high; i++) {
            pq.add(new Entry(Math.abs(X - arr[i]), i));
        }
        //take k elements out
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            result.add(arr[pq.poll().value]);
        }
        Collections.sort(result);
        return result;
    }

    public static List<Integer> findClosestElementsTwoPointer(int[] arr, int K, Integer X) {
        List<Integer> result = new LinkedList<>();
        int index = binarySearch(arr, X);
        int leftPtr = index;
        int rightPtr = index + 1;

        for (int i = 0; i < K; i++) {
            if(leftPtr >= 0 && rightPtr <= arr.length-1){
                int diff1 = Math.abs(X-arr[leftPtr]);
                int diff2 = Math.abs(X-arr[rightPtr]);
                if(diff1 <= diff2)
                    result.add(0,arr[leftPtr--]);
                else
                    result.add(arr[rightPtr++]);
            }
            else if(rightPtr > arr.length-1)
                result.add(0,arr[leftPtr--]);
            else if(leftPtr < 0)
                result.add(arr[rightPtr++]);
        }

        return  result;

    }

    public static int binarySearch(int[] arr, int X) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (X == arr[mid])
                return mid;

            if (X > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        if (start > 0)
            return start - 1;

        return start;
    }


    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElementsTwoPointer(new int[]{5, 6, 7, 8, 9}, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElementsTwoPointer(new int[]{2, 4, 5, 6, 9}, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElementsTwoPointer(new int[]{2, 4, 5, 6, 9}, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}

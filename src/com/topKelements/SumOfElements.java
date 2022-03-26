package com.topKelements;

import java.util.*;

class SumOfElements {

    public static int findSumOfElementsUsingMinHeap(int[] nums, int k1, int k2) {

        int sumOfElements = 0;
        if (k1 > nums.length)
            return sumOfElements;

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        for (int i = 0; i < k1; i++) {
            pq.poll();
        }

        for (int i = 0; i < k2 - k1 - 1; i++) {
            sumOfElements += pq.poll();
        }

        return sumOfElements;

    }

    public static int findSumOfElementsUsingMaxHeap(int[] nums, int k1, int k2) {

        int sumOfElements = 0;
        if (k1 > nums.length)
            return sumOfElements;

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);


        for (int i = 0; i < nums.length; i++) {
            if (i < k2 - 1)
                pq.add(nums[i]);
            else {
                if (nums[i] < pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }

            }
        }

        for (int i = 0; i < k2 - k1 - 1; i++) {
            sumOfElements += pq.poll();
        }



        return sumOfElements;

    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElementsUsingMaxHeap(new int[]{1, 3, 12, 5, 15, 11}, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElementsUsingMaxHeap(new int[]{3, 5, 8, 7}, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}


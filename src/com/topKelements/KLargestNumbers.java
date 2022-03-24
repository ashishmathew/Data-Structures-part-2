package com.topKelements;

import java.util.*;


public class KLargestNumbers {
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        // TODO: Write your code here
        //3, 1, 5, 12, 2, 11
        //Store the first K elements in the min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 0; i < k; i++) { // K * Log k
            pq.add(nums[i]);
        }

        //go through the array for the rest of the elements
        //and compare it to the first element in the heap
        //Remove the element from the heap if its smaller compared to t
        for (int i = k; i < nums.length; i++) { // N-k * logK
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }

        }

        return new ArrayList<>(pq);
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[]{3, 1, 5, 12, 2, 11}, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[]{5, 12, 11, -1, 12}, 3);
        System.out.println("Here are the top K numbers: " + result);
    }


}

package com.topKelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import java.util.*;

class KthLargestNumberInStream {

    private PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
    private int k;
    private int[] nums;

    public KthLargestNumberInStream(int[] nums, int k) {
        // TODO: Write your code here
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 5, 12, 2, 11};
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }

    public int add(int num) {
        // TODO: Write your code here
        pq.add(num);
        if(pq.size() > this.k)
            pq.poll();
        return pq.peek();
    }
}
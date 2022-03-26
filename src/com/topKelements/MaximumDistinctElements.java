package com.topKelements;

import java.util.*;

class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k) {
        int distinctElements = 0;
        if(k > nums.length)
            return distinctElements;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                distinctElements++;
            else
                minHeap.add(entry);
        }

        while (k > 0 && !minHeap.isEmpty()) {
            k -= minHeap.poll().getValue() - 1;
            if (k >= 0)
                distinctElements++;
        }

        if (k > 0)
            distinctElements -= k;

        return distinctElements;

    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[]{7, 3, 5, 8, 5, 3, 3}, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[]{3, 5, 12, 11, 12}, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[]{1, 2, 3, 3, 3, 3, 5, 5, 5}, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}


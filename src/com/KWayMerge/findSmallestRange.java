package com.KWayMerge;

import java.util.*;

class Range {
    int arrayIndex;
    int elementIndex;

    public Range(int arrayIndex, int elementIndex) {
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

class SmallestRange {

    public static int[] findSmallestRange(List<Integer[]> lists) {
        // TODO: Write your code here
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        int currentMaxNumber = Integer.MIN_VALUE;

        PriorityQueue<Range> minHeap = new PriorityQueue<>((n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex]
                - lists.get(n2.arrayIndex)[n2.elementIndex]);

        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new Range(i, 0));
            currentMaxNumber = Math.max(currentMaxNumber, lists.get(i)[0]);
        }

        while (minHeap.size() == lists.size()) {
            Range node = minHeap.poll();
            if(currentMaxNumber - lists.get(node.arrayIndex)[node.elementIndex] < rangeEnd - rangeStart){
                rangeEnd = currentMaxNumber;
                rangeStart = lists.get(node.arrayIndex)[node.elementIndex];
            }
            node.elementIndex++;
            if(node.elementIndex < lists.get(node.arrayIndex).length){
                minHeap.add(node);
                currentMaxNumber = Math.max(currentMaxNumber, lists.get(node.arrayIndex)[node.elementIndex]);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[]{1, 5, 8};
        Integer[] l2 = new Integer[]{4, 12};
        Integer[] l3 = new Integer[]{7, 8, 10};
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}


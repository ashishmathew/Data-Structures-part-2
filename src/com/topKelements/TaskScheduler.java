package com.topKelements;

import java.util.*;

class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        int minCPUIntervals = 0;

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            charFrequencyMap.put(tasks[i], charFrequencyMap.getOrDefault(tasks[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(charFrequencyMap.entrySet());

        while (!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            int i = k + 1;
            for (; i > 0 && !maxHeap.isEmpty(); i--) {
                minCPUIntervals++;
                Map.Entry<Character,Integer> entry = maxHeap.poll();
                if(entry.getValue()>1){
                    entry.setValue(entry.getValue()-1);
                    waitList.add(entry);
                }
            }

            maxHeap.addAll(waitList);
            if(!maxHeap.isEmpty())
                minCPUIntervals += i;

        }

        return minCPUIntervals;


    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'a', 'a', 'a', 'b', 'c', 'c'};
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[]{'a', 'b', 'a'};
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }
}


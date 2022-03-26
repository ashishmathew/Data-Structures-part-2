package com.topKelements;

import java.util.*;

class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k) {
        // TODO: Write your code here
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            charFrequencyMap.put(str.charAt(i), charFrequencyMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((e1,e2)->e2.getValue() - e1.getValue());
        maxHeap.addAll(charFrequencyMap.entrySet());

        Queue<Map.Entry<Character,Integer>> queue = new LinkedList<>();
        StringBuilder processedString = new StringBuilder(str.length());
        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> currentEntry = maxHeap.poll();
            processedString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue()-1);
            queue.offer(currentEntry);
            if(queue.size() == k){
                if(queue.peek().getValue() > 0)
                   maxHeap.offer(queue.poll());
            }
        }
        return processedString.length() == str.length() ? processedString.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}

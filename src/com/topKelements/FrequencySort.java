package com.topKelements;

import java.util.*;

class FrequencySort {

    public static String sortCharacterByFrequency(String str) {
        // TODO: Write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }//O(n)

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        maxHeap.addAll(map.entrySet());//nLogn

        StringBuilder sortedString = new StringBuilder(str.length());

        while(!maxHeap.isEmpty()){ //n^2 * logn
            Map.Entry<Character,Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sortedString.append(entry.getKey());
            }
        }

        return sortedString.toString();

    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}


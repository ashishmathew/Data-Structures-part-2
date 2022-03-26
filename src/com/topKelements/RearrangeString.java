package com.topKelements;


import java.util.*;

class RearrangeString {

    public static String rearrangeString(String str) {
        // TODO: Write your code here
        Map<Character,Integer> charFrequencyMap = new HashMap<>();
        //Compute the frequency map
        for (int i = 0; i < str.length(); i++) {
            charFrequencyMap.put(str.charAt(i), charFrequencyMap.getOrDefault(str.charAt(i),0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((n1,n2)->n2.getValue()-n1.getValue());
        //Add all the elements from the map to the maxHeap
        maxHeap.addAll(charFrequencyMap.entrySet());

        StringBuilder processedString = new StringBuilder(str.length());
        Map.Entry<Character,Integer> previousEntry = null;
        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> currentEntry =  maxHeap.poll();
            processedString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue()-1);
            if(previousEntry != null && previousEntry.getValue() > 0)
                maxHeap.add(previousEntry);
            previousEntry = currentEntry;
        }
        return processedString.length() == str.length()? processedString.toString() : "";

    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}

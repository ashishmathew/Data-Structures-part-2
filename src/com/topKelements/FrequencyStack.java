package com.topKelements;

import java.util.*;

class Element{
    int num;
    int frequency;
    int sequenceNumber;

    public Element(int num, int frequency, int sequenceNumber){
        this.num = num;
        this.frequency = frequency;
        this.sequenceNumber = sequenceNumber;
    }
}
class ElementComparator implements Comparator<Element>{
    @Override
    public int compare(Element o1, Element o2) {
        if(o1.frequency != o2.frequency)
            return o2.frequency - o1.frequency;
        return o2.sequenceNumber - o1.sequenceNumber;
    }
}

class FrequencyStack {
    private PriorityQueue<Element> maxHeap = new PriorityQueue<>(new ElementComparator());
    private Map<Integer,Integer> numberFrequencyMap = new HashMap<>();
    int seq = 0 ;
    public void push(int num) {
        // TODO: Write your code here
        numberFrequencyMap.put(num,numberFrequencyMap.getOrDefault(num,0)+1);
        maxHeap.add(new Element(num,numberFrequencyMap.get(num),seq++));
    }

    public int pop() {
        // TODO: Write your code here
        if(maxHeap.isEmpty()) return -1;
        Element element = maxHeap.poll();
        int number = element.num;
        if(numberFrequencyMap.get(number) > 1){
            numberFrequencyMap.put(number,numberFrequencyMap.get(number)-1);
        }
        else// There is no need to remove this in my opinion
            numberFrequencyMap.remove(number);
        return number;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());System.out.println(frequencyStack.pop());System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());System.out.println(frequencyStack.pop());System.out.println(frequencyStack.pop());System.out.println(frequencyStack.pop());System.out.println(frequencyStack.pop());
    }
}

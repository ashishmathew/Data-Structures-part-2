package com.topologicalSort;

import javax.management.QueryEval;
import java.util.*;

class SequenceReconstruction {
    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        // TODO: Write your code here\
        //basic checks
        if (originalSeq.length == 0 || sequences.length == 0)
            return false;
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //initialize the indegree and graph
        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length; i++) {
                indegree.putIfAbsent(sequence[i], 0);
                graph.putIfAbsent(sequence[i], new ArrayList<>());
            }
        }
        if(originalSeq.length != indegree.size())
            return  false;
        //Build the graph
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int parent = sequence[i - 1];
                int child = sequence[i];
                indegree.put(child, indegree.get(child) + 1);
                graph.get(parent).add(child);
            }
        }
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : indegree.entrySet()){
            if(entry.getValue() == 0)
                sources.add(entry.getKey());
        }
        List<Integer> sortedOrder = new ArrayList<>();
        while(!sources.isEmpty()){
            if(sources.size() > 1)
                return false;
            if(sources.peek()!= originalSeq[sortedOrder.size()])
                return false;
            Integer vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for(Integer child : children){
                indegree.put(child,indegree.get(child)-1);
                if(indegree.get(child) == 0)
                    sources.add(child);
            }
        }

        return sortedOrder.size() == originalSeq.length;

    }

    public static void main(String[] args) {
        boolean result = SequenceReconstruction.canConstruct(new int[]{1, 2, 3, 4},
                new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}});
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[]{1, 2, 3, 4},
                new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 4}});
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[]{3, 1, 4, 2, 5},
                new int[][]{new int[]{3, 1, 5}, new int[]{1, 4, 2, 5}});
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}
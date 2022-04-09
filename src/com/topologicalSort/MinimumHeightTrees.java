package com.topologicalSort;

import java.util.*;

class MinimumHeightTrees {
    public static List<Integer> findTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        // TODO: Write your code here
        if(nodes == 0)
            return minHeightTrees;

        if(nodes == 1){
            minHeightTrees.add(0);
            return minHeightTrees;
        }
        //Initialize degree and graph
        Map<Integer,Integer> degree = new HashMap<>();
        Map<Integer,List<Integer>> graph = new HashMap<>();
        //new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 }

        for (int i = 0; i < nodes; i++) {
            degree.put(i,0);
            graph.put(i,new ArrayList<>());
        }

        //Build the graph
        for(int[] edge : edges){
            for (int i = 1; i < edge.length; i++) {
                int n1 = edge[i-1], n2 = edge[i];
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
                degree.put(n1, degree.get(n1)+1);
                degree.put(n2, degree.get(n2)+1);
            }
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (Map.Entry<Integer,Integer> entry : degree.entrySet()){
            if(entry.getValue() == 1)
                leaves.add(entry.getKey());
        }

        int totalNodes = nodes;

        while(totalNodes > 2){
            int leavesSize = leaves.size();
            totalNodes -= leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                Integer leaf = leaves.poll();
                List<Integer> connections = graph.get(leaf);
                for (Integer connection : connections){
                    degree.put(connection,degree.get(connection)-1);
                    if(degree.get(connection) == 1)
                        leaves.add(connection);
                }
            }

        }
        minHeightTrees.addAll(leaves);
        return minHeightTrees;

    }

    public static void main(String[] args) {
        List<Integer> result = MinimumHeightTrees.findTrees(5,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
        System.out.println("Roots of MHTs: " + result);
    }
}
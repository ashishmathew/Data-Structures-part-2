package com.topologicalSort;

import java.util.*;

class AllTaskSchedulingOrders {
    public static void printOrders(int tasks, int[][] prerequisites) {
        // Initialize indegree and adj list
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            indegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        //Build indegree and adj list

        //[3 2 ]
        //[3 0 ]
        //[2 0 ]
        for (int i = 0; i < prerequisites.length; i++) {
            int child = prerequisites[i][1];
            int parent = prerequisites[i][0];
            graph.get(parent).add(child);
            indegree.put(child, indegree.get(child) + 1);
        }

        //Add source to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
                //break;
            }
        }

        //Print , backtrack and recursion
        List<Integer> sortedOrder = new ArrayList<>();
        printTopologicalSortOrders(queue, indegree, graph, sortedOrder);


    }

    public static void printTopologicalSortOrders(Queue<Integer> sources,
                                                  Map<Integer, Integer> indegree, Map<Integer, List<Integer>> graph,
                                                  List<Integer> sortedOrder) {

        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourceForNextCall = cloneQueues(sources);
                sourceForNextCall.remove(vertex);
                List<Integer> children = graph.get(vertex);
                for (Integer child : children) {
                    indegree.put(child, indegree.get(child) - 1);
                    if (indegree.get(child) == 0)
                        sourceForNextCall.add(child);
                }
                printTopologicalSortOrders(sourceForNextCall, indegree, graph, sortedOrder);

                sortedOrder.remove(vertex);
                for (Integer child : children) {
                    indegree.put(child, indegree.get(child) + 1);
                }
            }
        }
        if (sortedOrder.size() == indegree.size())
            System.out.println(sortedOrder);
    }

    private static Queue<Integer> cloneQueues(Queue<Integer> sources) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer entry : sources)
            clone.add(entry);
        return clone;
    }


    public static void main(String[] args) {
       AllTaskSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(4,
                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4},
                new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}});
        System.out.println();
    }
}
package com.topologicalSort;

import java.util.*;

class AlienDictionary {
    public static String findOrder(String[] words) {
        //"ba", "bc", "ac", "cab"
        //basic checks
        if (words == null || words.length == 0)
            return "";
        //Create indegree and the adjacency list
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        //Initialization
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                indegree.put(ch, 0);
                graph.put(ch, new ArrayList<>());
            }
        }
        //"ba", "bc", "ac", "cab"
        //Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String parent = words[i];
            String child = words[i + 1];
            for (int j = 0; j < Math.min(parent.length(), child.length()); j++) {
                if (parent.charAt(j) != child.charAt(j)) {
                    graph.get(parent.charAt(j)).add(child.charAt(j));
                    indegree.put(child.charAt(j), indegree.get(child.charAt(j)) + 1);
                    break;
                }
            }
        }
        //Add the sources to the queue
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0)
                queue.add(entry.getKey());
        }

        StringBuilder sortedString = new StringBuilder();
        //find the topological order
        while (!queue.isEmpty()) {
            Character vertex = queue.poll();
            sortedString.append(vertex);
            List<Character> children = graph.get(vertex);
            for(Character ch : children){
                indegree.put(ch,indegree.get(ch) -1 );
                if(indegree.get(ch) == 0)
                    queue.add(ch);
            }
        }

        if(sortedString.length() != indegree.size())
            return "";

        return sortedString.toString();

    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[]{"ba", "bc", "ac", "cab"});
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[]{"cab", "aaa", "aab"});
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[]{"ywx", "wz", "xww", "xz", "zyy", "zwz"});
        System.out.println("Character order: " + result);
    }
}

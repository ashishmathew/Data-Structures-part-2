package com.topKelements;

import java.util.PriorityQueue;

class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        // TODO: Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)->n1-n2);

        for (int i = 0; i < ropeLengths.length; i++) {
            pq.add(ropeLengths[i]);
        }

        int result = 0 ;
        while(pq.size() > 1) {
            int tmp = pq.poll() + pq.poll();
            result += tmp;
            pq.add(tmp);
        }


        return result;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }

}





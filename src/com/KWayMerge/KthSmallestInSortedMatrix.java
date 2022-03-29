package com.KWayMerge;

import java.util.*;

class MatrixNode {
    int row;
    int col;

    public MatrixNode(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        // TODO: Write your code here
        int result = -1;
        PriorityQueue<MatrixNode> minheap = new PriorityQueue<>((e1, e2) ->
                matrix[e1.row][e1.col] - matrix[e2.row][e2.col]);

        for (int i = 0; i < matrix.length && i < k; i++) {
            minheap.add(new MatrixNode(i,0));
        }

        int counter = 0 ;
        while(!minheap.isEmpty()){
            MatrixNode node = minheap.poll();
            result = matrix[node.row][node.col++];
            if(++counter == k)
                break;
            if(matrix[0].length > node.col)
                minheap.add(node);
        }

        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}



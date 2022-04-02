package com.DP;

import java.util.*;

class Knapsack {

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return helperSolveKnapsackRecursive(profits, weights, capacity, 0,dp);
    }

    public int helperSolveKnapsackRecursive(int[] profits, int[] weights, int capacity, int currentIdx, Integer[][] dp) {

        if (currentIdx >= profits.length || capacity <= 0)
            return 0;

        if(dp[currentIdx][capacity] != null)
            return dp[currentIdx][capacity];


        int leftTreeProfit = 0;

        if (weights[currentIdx] <= capacity) {
            leftTreeProfit = profits[currentIdx] + helperSolveKnapsackRecursive(profits, weights,
                    capacity - weights[currentIdx], currentIdx + 1,dp);
        }

        int rightTreeProfit = helperSolveKnapsackRecursive(profits, weights,
                capacity, currentIdx + 1,dp);

        dp[currentIdx][capacity] = Math.max(leftTreeProfit, rightTreeProfit);
        return Math.max(leftTreeProfit, rightTreeProfit);

    }
}
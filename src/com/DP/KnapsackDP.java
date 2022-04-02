package com.DP;

class KnapsackDP {

    public static void main(String[] args) {
        KnapsackDP ks = new KnapsackDP();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        //populate columns
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        //populate rows
        for (int i = 1; i < capacity + 1; i++) {
            if (weights[0] <= i)
                dp[0][i] = profits[0];
        }

        //populate the matrix

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                int profit1 = 0, profit2 = 0;

                if (weights[i] <= j)
                    profit1 = profits[i] + dp[i - 1][j - weights[i]];

                profit2 = dp[i - 1][j];

                dp[i][j] = Math.max(profit1, profit2);
            }
        }
        return dp[n - 1][capacity];
    }


}
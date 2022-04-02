package com.DP;

class KnapsackDPoptimal {

    static int solveKnapsack(int[] profits, int[] weights, int capacity) {

        if (capacity <= 0 || profits.length == 0 || profits.length != weights.length)
            return 0;

        int[][] dp = new int[2][capacity + 1];

        for (int c = 0; c < capacity + 1; c++) {
            if (weights[0] <= c)
                dp[0][c] = dp[1][c] = profits[0];
        }

        int n = profits.length;


        for (int i = 1; i < n; i++) {
            for (int c = 0; c < capacity + 1; c++) {
                int profit1 = 0 ;
                int profit2 = 0 ;
                if(weights[i] <= c)
                    profit1 = profits[i] + dp[(i-1)%2][c-weights[i]];
                profit2 = dp[(i-1)%2][c];
                dp[i%2][c] = Math.max(profit1,profit2);
            }
        }

        return dp[(n-1)%2][capacity];

    }

    public static void main(String[] args) {
        KnapsackDPoptimal ks = new KnapsackDPoptimal();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
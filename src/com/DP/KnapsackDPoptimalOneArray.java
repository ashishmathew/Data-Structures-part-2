package com.DP;

class KnapsackDPoptimalOneArray {

    static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if(capacity <= 0 || profits.length == 0 || profits.length != weights.length)
            return 0;

        int[] dp = new int[capacity + 1];

        for (int c = 0; c < capacity + 1; c++) {
            if(weights[0] <= c)
                dp[c] = profits[0];
        }

        int  n = profits.length;
        for (int i = 1; i < n; i++) {
            for (int c = capacity; c >= 0; c--) {
                int profits1 = 0;
                int profits2 = 0 ;

                if(weights[i] <= c)
                    profits1 = profits[i] + dp[c - weights[i]];

                profits2 = dp[c];

                dp[c] = Math.max(profits1,profits2);
            }
        }

        return dp[capacity];

    }

    public static void main(String[] args) {
        KnapsackDPoptimalOneArray ks = new KnapsackDPoptimalOneArray();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
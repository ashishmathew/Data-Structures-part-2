package com.DP;

class PartitionSetMinSumMemoization {

    public static void main(String[] args) {
        PartitionSetMinSumMemoization ps = new PartitionSetMinSumMemoization();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
         num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }

    public int canPartition(int[] num) {

        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        Integer[][] dp = new Integer[num.length][sum + 1];
        return canPartitionRecursive(num, 0, 0, 0, dp);
    }

    public int canPartitionRecursive(int[] num, int sum1, int sum2, int currentIdx, Integer[][] dp) {
        if (num.length == currentIdx)
            return Math.abs(sum1 - sum2);

        if (dp[currentIdx][sum1] == null) {
            int diff1 = canPartitionRecursive(num, sum1 + num[currentIdx], sum2, currentIdx + 1, dp);
            int diff2 = canPartitionRecursive(num, sum1, sum2 + num[currentIdx], currentIdx + 1, dp);

            dp[currentIdx][sum1] = Math.min(diff1, diff2);
        }
        return dp[currentIdx][sum1];
    }
}
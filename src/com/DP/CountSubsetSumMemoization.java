package com.DP;

class CountSubsetSumMemoization {
    static int countSubsets(int[] num, int sum) {
        //TODO: Write - Your - Code
        Integer[][] dp = new Integer[num.length][sum+1];
        return countSubsetsRecursive(num, sum, 0,dp);
    }

    public static int countSubsetsRecursive(int[] num, int sum, int currentIdx,Integer[][] dp) {
        if (sum == 0)
            return 1;
        if (currentIdx >= num.length)
            return 0;

        if(dp[currentIdx][sum] == null){
            int sum1 = 0 ;
            if(num[currentIdx] <= sum)
             sum1 = countSubsetsRecursive(num, sum - num[currentIdx], currentIdx + 1,dp);

            int sum2 = countSubsetsRecursive(num, sum, currentIdx + 1,dp);
            dp[currentIdx][sum] = sum1 + sum2;
        }
        return dp[currentIdx][sum];
    }

    public static void main(String[] args) {
        CountSubsetSumMemoization ss = new CountSubsetSumMemoization();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}
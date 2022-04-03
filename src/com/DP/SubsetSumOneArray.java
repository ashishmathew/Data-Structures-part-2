package com.DP;
class SubsetSumOneArray {

    public boolean canPartition(int[] num, int sum) {
        // TODO: Write your code here
        Boolean [] dp = new Boolean[sum + 1];
        dp[0] = true;

        for (int s = 1; s <= sum; s++)
            dp[s] = (num[0] == s ? true : false);

        for (int i = 1; i < num.length; i++) {
            for (int s = sum; s >= 0; s--) {
                if(num[i] >= s)
                    dp[s] = dp[s];
                else
                    dp[s] =  dp[s] || dp[s-num[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        SubsetSumOneArray ss = new SubsetSumOneArray();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }
}
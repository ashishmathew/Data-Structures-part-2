package com.DP;
class SubsetSum {

    public boolean canPartition(int[] num, int sum) {
        // TODO: Write your code here

        Boolean[][] dp = new Boolean[num.length][sum + 1];

        for (int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum; s++) {
            if(num[0] == s)
                dp[0][s] = true;
            else
                dp[0][s] = false;

            //  dp[0][s] = (num[0] == s ? true : false);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if(num[i] >= s)
                    dp[i][s] = dp[i-1][s];
                else
                    dp[i][s] = dp[i-1][s] || dp[i-1][s-num[i]];
            }
        }
        return dp[num.length-1][sum];



    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }
}
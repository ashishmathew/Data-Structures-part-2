package com.DP;

class CountSubsetSumDP {
    static int countSubsets(int[] num, int sum) {
        //TODO: Write - Your - Code
        Integer[][] dp = new Integer[num.length][sum + 1];

        for (int i = 0; i < num.length; i++) {
            dp[i][0] = 1;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? 1 : 0);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum; s++) {
                dp[i][s] = dp[i-1][s];
                if(num[i] <= s)
                    dp[i][s] = dp[i][s] + dp[i-1][s-num[i]];
            }
        }
        return dp[num.length-1][sum];

    }


    public static void main(String[] args) {
        CountSubsetSumDP ss = new CountSubsetSumDP();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}
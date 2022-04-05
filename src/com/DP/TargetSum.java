package com.DP;

class TargetSum {

    public int findTargetSubsets(int[] num, int s) {
        // TODO: Write your code here
        int totalSum = 0;
        for(int n : num)
            totalSum += n;

        // s1  - s2 = s
        // s1 + s2 = Sum
        //s1 - Sum + s1 = s
        // s1 = (s + Sum)/2

        //why ??? Try to figure this out during revision
        if(totalSum < s || (totalSum + s) % 2 == 1)
            return 0;

        //return countSubSetSum(num,(totalSum+s)/2);

        return countSubSetSumOneArray(num,(totalSum+s)/2);

    }

    public int countSubSetSumOneArray(int[] num, int sum) {
        Integer[] dp = new Integer[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= sum; i++) {
            dp[i] = (num[0] == i ? 1 :0);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = sum; s >= 0 ; s--) {
                if(s >= num[i])
                    dp[s] += dp[s - num[i]];

            }
        }
        return dp[sum];

    }

    public int countSubSetSum(int[] num, int sum) {

        Integer[][] dp = new Integer[num.length][sum + 1];

        for (int i = 0; i < num.length; i++) {
            dp[i][0] = 1;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? 1 :0);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = 0; s <= sum; s++) {
                dp[i][s] = dp[i-1][s];
                if(s >= num[i])
                    dp[i][s] += dp[i-1][s - num[i]];
            }
        }

        return dp[num.length-1][sum];

    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}

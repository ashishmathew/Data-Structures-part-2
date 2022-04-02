package com.DP;

class PartitionSetDP {

    static boolean canPartition(int[] num) {
        //TODO: Write - Your - Code

        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += i;
        }

        if(sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[num.length][(sum / 2) + 1];

        for (int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum/2; s++) {
            if(num[0] == s)
                dp[0][s] = true;
            else
                dp[0][s] = false;

          //  dp[0][s] = (num[0] == s ? true : false);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum/2; s++) {
              if(num[i] >= s)
                  dp[i][s] = dp[i-1][s];
              else
                  dp[i][s] = dp[i-1][s-num[i]];
            }
        }
        return dp[num.length-1][sum/2];
    }


    public static void main(String[] args) {
        PartitionSetDP ps = new PartitionSetDP();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
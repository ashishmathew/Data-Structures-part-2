package com.DP;

class PartitionSetMinSumDP {

    public static void main(String[] args) {
        PartitionSetMinSumDP ps = new PartitionSetMinSumDP();
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
        int totalSum = sum;
        sum = sum / 2;
        Boolean[][] dp = new Boolean[num.length][sum + 1];

        for (int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? true:false);
        }

        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j <= sum ; j++) {
                /*if(dp[i-1][j])
                    dp[i][j] = dp[i-1][j];
                else if(j >= num[i])
                    dp[i][j] = dp[i-1][j-num[i]];*/
                if(num[i] >= j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-num[i]];

            }
        }

        int sum1 = 0 ;
        int sum2 = 0 ;
        for (int s = sum; s >= 0 ; s--) {
            if(dp[num.length-1][s]){
                sum1 = s;
                break;
            }
        }

        sum2 = totalSum - sum1;
        return Math.abs(sum1 - sum2);

    }


}
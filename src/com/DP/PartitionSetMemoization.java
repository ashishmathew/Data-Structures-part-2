package com.DP;

class PartitionSetMemoization {

    static boolean canPartition(int[] num) {
        //TODO: Write - Your - Code
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;
        Boolean[][] dp = new Boolean[num.length][(sum / 2) + 1];
        return canPartitionRecursive(num, 0, sum / 2, dp);

    }

    public static boolean canPartitionRecursive(int[] num, int currentIdx, int sum, Boolean[][] dp) {
        if (sum == 0)
            return true;
        if (currentIdx >= num.length)
            return false;

    /*    if(dp[currentIdx][sum] != null)
             return dp[currentIdx][sum];

        if (num[currentIdx] <= sum){
            dp[currentIdx][sum] =  canPartitionRecursive(num, currentIdx + 1, sum - num[currentIdx], dp);
            return dp[currentIdx][sum];
        }

        dp[currentIdx][sum] =  canPartitionRecursive(num, currentIdx + 1, sum, dp);
        return dp[currentIdx][sum];*/

        //Refactor code
        if (dp[currentIdx][sum] == null) {
            if (num[currentIdx] <= sum) {
                dp[currentIdx][sum] = canPartitionRecursive(num, currentIdx + 1, sum - num[currentIdx], dp);
                return dp[currentIdx][sum];
            }

            dp[currentIdx][sum] = canPartitionRecursive(num, currentIdx + 1, sum, dp);
        }
        return dp[currentIdx][sum];
    }

    public static void main(String[] args) {
        PartitionSetMemoization ps = new PartitionSetMemoization();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
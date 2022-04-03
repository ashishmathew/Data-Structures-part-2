package com.DP;

class PartitionSetMinSumRecursive {

    public static void main(String[] args) {
        PartitionSetMinSumRecursive ps = new PartitionSetMinSumRecursive();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }

    public int canPartition(int[] num) {
        return canPartitionRecursive(num, 0, 0, 0);
    }

    public int canPartitionRecursive(int[] num, int sum1, int sum2, int currentIdx) {
        if (num.length == currentIdx)
            return Math.abs(sum1 - sum2);
        int diff1 = canPartitionRecursive(num, sum1 + num[currentIdx], sum2, currentIdx + 1);
        int diff2 = canPartitionRecursive(num, sum1, sum2 + num[currentIdx], currentIdx + 1);
        return Math.min(diff1, diff2);
    }
}
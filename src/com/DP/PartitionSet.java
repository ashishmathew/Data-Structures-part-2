package com.DP;

class PartitionSet {

    static boolean canPartition(int[] num) {
        //TODO: Write - Your - Code
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;

        return canPartitionRecursive(num, 0, sum / 2);

    }

    public static boolean canPartitionRecursive(int[] num, int currentIdx, int sum) {
        if(sum == 0)
            return true;
        if(currentIdx >= num.length)
            return false;

        if(num[currentIdx] <= sum)
            return canPartitionRecursive(num,currentIdx+1,sum - num[currentIdx]);

        return canPartitionRecursive(num,currentIdx+1,sum);

    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
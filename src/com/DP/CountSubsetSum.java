package com.DP;

class CountSubsetSum {
    static int countSubsets(int[] num, int sum) {
        //TODO: Write - Your - Code
        return countSubsetsRecursive(num, sum, 0);

    }

    public static int countSubsetsRecursive(int[] num, int sum, int currentIdx) {

        if (sum == 0)
            return 1;
        if (currentIdx >= num.length)
            return 0;

        int sum1 = 0 ;
        if(num[currentIdx] <= sum)
            sum1 = countSubsetsRecursive(num, sum - num[currentIdx], currentIdx + 1);
        int sum2 = countSubsetsRecursive(num, sum, currentIdx + 1);

        return sum1 + sum2;
    }

    public static void main(String[] args) {
        CountSubsetSum ss = new CountSubsetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}
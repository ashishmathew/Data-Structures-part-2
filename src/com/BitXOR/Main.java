package com.BitXOR;

public class Main {

    public static void main(String[] args) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3,3,4}));
    }

    public static int findSingleNumber(int[] ints) {
        int num = ints[0];
        for (int i = 1; i < ints.length; i++) {
            num ^= ints[i];
        }
        return num;
    }


    //4= 0 1 0 0
    //   0 1 0 0
    public static int countBits(int x) {
        int numBits = 0;
        while (x != 0) {
            numBits += (x & 1);
            x >>>= 1;
        }
        return numBits;
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        // find sum of all numbers from 1 to n.
        int x1 = 1;
        for (int i = 2; i <= n; i++)
            x1 = x1 ^ i;

        // x2 represents XOR of all values in arr
        int x2 = arr[0];
        for (int i = 1; i < n - 1; i++)
            x2 = x2 ^ arr[i];

        // missing number is the xor of x1 and x2
        return x1 ^ x2;
    }


}

package com.BitXOR;

public class TwoSingleNumbers {

    public static void main(String[] args) {

    /*    int[] arr = new int[]{1, 4, 2, 1, 3, 5, 6, 2, 3, 5};
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);*/

        int[] arr = new int[]{2, 1, 3, 2};
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }

    public static int[] findSingleNumbers(int[] arr) {

        //2, 1, 3, 2
        //XOR of all the numbers in the array
        int arrXOR = 0;
        for (int i = 0; i < arr.length; i++) {
            arrXOR ^= arr[i];
        }
        //1 =  0001
        //3 =  0011
        //XOR= 0010

        //Identify one of the least significant bit - rightmost which is set
        int rightmostSetBit = 1;
        while ((rightmostSetBit & arrXOR) == 0) {
            rightmostSetBit <<= 1;
        }
        //0010

        //Partition the elements in the arrays in two groups
        //One with the bit in the rightmostSetBit set
        //One with the bit in the rightmostSetBit not set
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightmostSetBit) == 0)//bit is not set
                num1 ^= arr[i];
            else                              //bit is set
                num2 ^= arr[i];
        }
        return new int[]{num1, num2};
    }


}

package com.BitXOR;

public class CalculateComplement {

    public static void main(String[] args) {

        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(4));
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
    }

    public static int bitwiseComplement(int num) {
        //find number of bits used to represent the number
        int numOfBits = 0 ;
        int n = num;
        while(n > 0) {
            numOfBits++;
            n >>= 1;
        }

        int allBitsSet = (int)Math.pow(2,numOfBits) - 1;

        return num ^ allBitsSet;
    }



}

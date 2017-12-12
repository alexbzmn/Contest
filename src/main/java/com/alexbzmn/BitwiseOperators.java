package com.alexbzmn;

public class BitwiseOperators {
    public static void main(String[] args) {

        int a = 0b00000111;

        System.out.println(a >> 1);
        System.out.println(Integer.toBinaryString( -a));
        System.out.println(Integer.toBinaryString( -a >>> 1));
        System.out.println(Integer.toBinaryString(a >>> 1));

        System.out.println(a >>> 1);
        System.out.println(-a >>> 1);
    }
}

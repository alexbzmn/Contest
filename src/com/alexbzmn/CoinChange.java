package com.alexbzmn;

import java.util.Scanner;

/**
 * Created by User on 7/8/2017.
 */
public class CoinChange {
    public static long makeChange(int[] coins, int money) {

        long ways[] = new long[money + 1];
        ways[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < ways.length; i++) {
                ways[i] += ways[i - coin];
            }
        }

        return ways[money];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}

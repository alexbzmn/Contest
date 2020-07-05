package com.alexbzmn;

import java.util.Arrays;

public class CoinChangeFewest {

	public static void main(String[] args) {
		System.out.println(new CoinChangeFewest().coinChange(new int[] { 186, 419, 83, 408 }, 6249));
	}

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for (int j = 1; j <= amount; j++) {
			for (int c : coins) {
				if (j - c < 0) {
					continue;
				}

				dp[j] = Math.min(dp[j], dp[j - c] + 1);
			}
		}

		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
}

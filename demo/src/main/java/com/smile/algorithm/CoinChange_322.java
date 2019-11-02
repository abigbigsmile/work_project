package com.smile.algorithm;

import java.util.Arrays;

/**
 * 完全背包问题
 */
public class CoinChange_322 {

    public static void main(String[] args) {
        int[] coins = new int[]{2,5,10,1};
        int amount = 27;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange_x(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0; i<coins.length; i++){
            for(int j=coins[i]; j<=amount; j++){
                for(int k=0; k*coins[i]<=j; k++){
                    if(dp[j-k*coins[i]] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], k+dp[j-k*coins[i]]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static int coinChange_x(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

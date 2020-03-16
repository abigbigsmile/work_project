package com.smile.algorithm;

import java.util.Arrays;

/**
 * 完全背包问题
 */
public class Knapsack01_x {

    public static void main(String[] args) {
        /*int[] w = {3,5,1,2,2};
        int[] v = {4,5,2,1,3};
        int maxWeight = 8;*/

        int[] w = {3,4,2};
        int[] v = {4,5,3};
        int maxWeight = 7;

        System.out.println(bestValue(w, v, maxWeight));
        System.out.println(bestValue_x(w, v, maxWeight));
        System.out.println(bestValue_xx(w, v, maxWeight));

    }

    private static int bestValue(int[] w, int[] v, int maxWeight) {
        if(v.length == 0 || w.length == 0) return 0;
        int[][] dp = new int[v.length][maxWeight+1];

        for(int i=0; i<v.length; i++){
            for(int j=maxWeight; j>=w[i]; j--){
                for(int k=0; k*w[i] <= j; k++){
                    if(i == 0) dp[i][j] = v[i]*k;
                    else dp[i][j] = Math.max(dp[i][j], v[i]*k + dp[i-1][j-k*w[i]]);
//                    else dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j]), v[i]*k + dp[i-1][j-k*w[i]]); //理解一下这一句，为什么还要判断Math.max(dp[i-1][j], dp[i][j])
                }
            }
        }
        return dp[v.length-1][maxWeight];
    }

    /**
     * 完全背包问题模板
     * @param w
     * @param v
     * @param maxWeight
     * @return
     */
    private static int bestValue_x(int[] w, int[] v, int maxWeight) {
        if(v.length == 0 || w.length == 0) return 0;
        int[] dp = new int[maxWeight+1];
        for(int i=0; i<v.length; i++){
            for(int j=w[i]; j<=maxWeight; j++){
                dp[j] = Math.max(dp[j], v[i] + dp[j-w[i]]);
            }
        }
        return dp[maxWeight];
    }

    private static int bestValue_xx(int[] w, int[] v, int maxWeight) {
        if(v.length == 0 || w.length == 0) return 0;
        int[][] dp = new int[v.length][maxWeight+1];

        for(int i=0; i<v.length; i++){
            for(int j=0; j<=maxWeight; j++){
                if(i>0) dp[i][j] = dp[i-1][j];
                for(int k=0; k*w[i]<=j; k++){
                    dp[i][j] = Math.max(dp[i][j], k*v[i]+dp[i][j-k*w[i]]);
                }
            }
        }
        return dp[v.length-1][maxWeight];
    }

}

package com.smile.algorithm_review.DynamicProgramming;

public class Knapsack01_x {

    public static void main(String[] args) {
        int[] w = {3,5,1,2,2};
        int[] v = {4,5,2,1,3};
        int maxWeight = 8;


       /* int[] w = {3,4,2};
        int[] v = {4,5,3};
        int maxWeight = 7;*/
        System.out.println(bestValue(w, v, maxWeight));
        System.out.println(bestValue_x(w, v, maxWeight));
        System.out.println(bestValue_xx(w, v, maxWeight));
    }

    private static int bestValue(int[] w, int[] v, int maxWeight) {
        int[][] dp = new int[v.length][maxWeight+1];
        // 递推初始化
        for(int i=0; i<=maxWeight; i++) {
            if(i<w[0]) continue;
            for(int j=1; j*w[0]<=i; j++){
                dp[0][i] = j*v[0];
            }
        }

        for(int i=1; i<v.length; i++){
            for(int j=0; j<=maxWeight; j++){
                dp[i][j] = dp[i-1][j];
                for(int k=0; k*w[i]<=j; k++){
                    dp[i][j] = Math.max(dp[i][j], k*v[i] + dp[i-1][j-k*w[i]]);
                }
            }
        }

        return dp[v.length-1][maxWeight];
    }

    // 上一版本的垃圾优化
    private static int bestValue_x(int[] w, int[] v, int maxWeight) {
        int[][] dp = new int[v.length][maxWeight+1];

        for(int i=0; i<v.length; i++){
            for(int j=0; j<=maxWeight; j++){
                if(i>0) dp[i][j] = dp[i-1][j];
                for(int k=0; k*w[i]<=j; k++){
                    if(i==0) dp[i][j] = k*v[i];
                    else dp[i][j] = Math.max(dp[i][j], k*v[i] + dp[i-1][j-k*w[i]]);
                }
            }
        }

        return dp[v.length-1][maxWeight];
    }

    // 上一版本的垃圾优化
    private static int bestValue_xx(int[] w, int[] v, int maxWeight) {
        int[] dp = new int[maxWeight+1];

        for(int i=0; i<v.length; i++){
            for(int j=w[i]; j<=maxWeight; j++){
                dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
            }
        }

        return dp[maxWeight];
    }




}

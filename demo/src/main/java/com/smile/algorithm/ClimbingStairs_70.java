package com.smile.algorithm;

public class ClimbingStairs_70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) dp[1] = dp[1-1] + dp[1-2];
        return dp[n];
    }

}

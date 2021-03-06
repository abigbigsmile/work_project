package com.smile.algorithm_review.DynamicProgramming;

public class ClimbingStairs_70 {

    public static void main(String[] args) {

    }

    public static int climbStairs(int n) {
        if(n==0 || n==1) return 1;
        else return climbStairs(n-1) + climbStairs(n-2);
    }

    public static int climbStairs_x(int n) {
        if(n==0 || n==1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<n; i++) dp[i] = dp[i-1]+dp[i-2];
        return dp[n-1];
    }
}

package com.smile.algorithm;

public class IntegerBreak_343 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak_x(n));
    }

    public static int integerBreak(int n) {
        return backtrack(n);
    }

    //分割n（至少分割成两部分)，返回乘积最大值
    public static int backtrack(int n){
        if(n == 1) return 1; //1不能再分割
        int max = -1;
        for(int i=1; i<=n-1; i++){
            //将n分割成i 和 n-i；或者时 i 和 将n-i再分割求最大值
            max = Math.max(max, Math.max(i*(n-i), i * backtrack(n-i)));
        }
        return max;
    }

    public static int integerBreak_x(int n) {
        return backtrack(n, new int[n+1]);
    }

    //分割n（至少分割成两部分)，返回乘积最大值
    public static int backtrack(int n, int[] dp){
        if(n == 1) return 1; //1不能再分割
        if(dp[n] != 0) return dp[n];

        int max = -1;
        for(int i=1; i<=n-1; i++){
            //将n分割成i 和 n-i；或者时 i 和 将n-i再分割求最大值
            max = Math.max(max, Math.max(i*(n-i), i * backtrack(n-i, dp)));
        }

        dp[n] = max;
        return max;
    }
}

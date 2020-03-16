package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 0:14
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Seven {

    public static void main(String[] args) {
        System.out.println(Fibonacci_x(3));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<n; i++) dp[i] = dp[i-1] + dp[i-2];
        return dp[n-1];
    }

    public static int Fibonacci_x(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        return Fibonacci_x(n-1)+Fibonacci_x(n-2);
    }

}

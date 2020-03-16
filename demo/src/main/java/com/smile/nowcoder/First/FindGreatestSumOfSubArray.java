package com.smile.nowcoder.First;

public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(array));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        dp[1] = Math.max(array[1], dp[0]+array[1]);
        for(int i=2; i<array.length; i++){
            dp[i] = Math.max(array[i], dp[i-1]+array[i]);
            for(int j=0; j<i-1; j++){
                dp[i] = Math.max(dp[i], dp[j]);
            }
        }
        int res = Integer.MIN_VALUE;
        for(int value : dp) res = Math.max(value, res);
        return res;
    }
}

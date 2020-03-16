package com.smile.algorithm_review.DynamicProgramming;

import java.util.Arrays;

public class WiggleSubsequence_376 {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,5};
        System.out.println(wiggleMaxLength(nums));
    }

    public static int wiggleMaxLength(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(j==0) dp[i] = nums[i]==nums[j]? dp[j] : dp[j]+1;
                else{
                    if((nums[j]-nums[j-1])*(nums[i]-nums[j]) < 0) dp[i] = Math.max(dp[i], dp[j]+1);
                    else dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }

        return dp[nums.length-1];
    }
}

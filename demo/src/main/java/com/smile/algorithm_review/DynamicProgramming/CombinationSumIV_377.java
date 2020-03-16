package com.smile.algorithm_review.DynamicProgramming;

public class CombinationSumIV_377 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }


    public static int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length][target+1];
        dp[0][0] = 1;
        for(int i=1; i<=target; i++){
            if(i%nums[0]==0) dp[0][i]++;
        }

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<=target; j++){
                for(int k=0; k*nums[i]<=j; k++){
                    dp[i][j] += dp[i-1][j-k*nums[i]];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}

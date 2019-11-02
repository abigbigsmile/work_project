package com.smile.algorithm;

public class TargetSum_494 {


    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,1};
        int S = 1;
        System.out.println(findTargetSumWays(nums, S));
    }

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum < S || -sum >S) return 0;

        int[][] dp = new int[nums.length][2*sum+2];
        for(int j=0; j< 2*sum+2; j++){
            if(j + nums[0] == sum) dp[0][j] += 1;
            if(j - nums[0] == sum) dp[0][j] += 1;
        }


        for(int i=1; i<nums.length; i++){
            for(int j=0; j<2*sum+2; j++){
                if(j-nums[i]>=0 && j-nums[i]<2*sum+2) dp[i][j] += dp[i-1][j-nums[i]];
                if(j+nums[i]>=0 && j+nums[i]<2*sum+2) dp[i][j] += dp[i-1][j+nums[i]];
            }
        }
        return dp[nums.length-1][S+sum];
    }
}

package com.smile.algorithm;

import java.util.Arrays;

/**
 * 动态规划问题
 */
public class LongestIncreasingSubsequence_300 {

    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS_x(nums));
        System.out.println(lengthOfLIS_xx(nums));
    }

    //递归回溯
    public static int lengthOfLIS(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, helper(nums, i, 1));
        }
        return max;
    }

    public static int helper(int[] nums, int index, int count){
        if(index == nums.length) return count;
        int max = count;
        for(int i=index+1; i<nums.length; i++){
            if(nums[i]> nums[index]) max = Math.max(max, helper(nums, i, count+1));
        }
        return max;
    }

    public static int lengthOfLIS_x(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int res = 1;
        for(int len : dp) res = Math.max(res, len); //注意：不一定是最后一个是最大值
        return res;
    }

    public static int lengthOfLIS_xx(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }


}

package com.smile.algorithm;

public class HouseRobberII_213 {

    public static void main(String[] args) {
        int[] house = new int[]{2};
        System.out.println(rob(house));
    }

    //这里由于形成一个圆环，所以需要分情况：抢劫首家房子/不抢劫首家房子，因为这会影响是否抢最后一家房子
    public static int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length+1];
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));

    }

    //辅助方法，限定范围。 状态定义：抢劫 [first, last]范围的房子的最大价值
    public static int helper(int[] nums, int first, int last) {
        if(first > last) return nums[0];
        int[] dp = new int[last + 1];
        dp[first] = nums[first];
        for(int i=first+1; i<=last; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + (i-2>=0?dp[i-2]:0));
        }
        return dp[last];
    }
}

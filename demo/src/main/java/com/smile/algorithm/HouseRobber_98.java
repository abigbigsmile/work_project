package com.smile.algorithm;

public class HouseRobber_98 {

    public static void main(String[] args) {
        int[] house = new int[]{2,7,9,3,1};
        System.out.println(rob_x(house));
    }

    public static int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for(int i=2; i<=nums.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[nums.length];

    }

    public static int rob_x(int[] nums) {
        int ifRobbedPrevious = 0; 	// max monney can get if rob current house
        int ifDidntRobPrevious = 0; // max money can get if not rob current house

        // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
        for(int i=0; i < nums.length; i++)
        {
            // If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
            int currRobbed = ifDidntRobPrevious + nums[i];

            // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
            int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);

            // Update values for the next round
            ifDidntRobPrevious  = currNotRobbed;
            ifRobbedPrevious = currRobbed;
        }

        return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
    }

}

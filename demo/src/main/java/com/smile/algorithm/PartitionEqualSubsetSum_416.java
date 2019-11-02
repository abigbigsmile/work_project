package com.smile.algorithm;

public class PartitionEqualSubsetSum_416 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition_x(nums));


    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if((sum&1)==1) return false; //当总和为奇数时返回false
        sum /= 2;
        boolean[] dp = new boolean[sum+1];

        for(int j=0; j<=sum; j++) dp[j] = (j==nums[0]);

        for(int i=1; i<nums.length; i++){
            for(int j=sum; j>=nums[i]; j--){
               dp[j] = (dp[j] || dp[j-nums[i]]);
            }
        }
        return dp[sum];
    }

    //下面是错的，这个真的要注意了
    public static boolean canPartition_x(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if((sum&1)==1) return false; //当总和为奇数时返回false
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        for(int j=0; j<=sum; j++) dp[j] = (j==nums[0]);
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<=sum; j++){
                if(j>=nums[i]) dp[j] = (dp[j] || dp[j-nums[i]]);
            }
        }
        return dp[sum];
    }
}

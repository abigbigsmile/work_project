package com.smile.algorithm_review;

/**
 * 滑动窗口类型
 */
public class MinimumSizeSubarraySum_209 {

    public static void main(String[] args) {
        int[] nums = {1,1};
        int s = 3;
        System.out.println(minSubArrayLen(s, nums));
        System.out.println();
    }

    // 滑动窗口
    public static int minSubArrayLen(int s, int[] nums) {
        int min=nums.length+1;
        int left=0;
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            while (sum >= s){
                min = Math.min(min, i-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return min==nums.length+1? 0 : min;
    }

    public static int minSubArrayLen_x(int s, int[] nums) {
        int left = 0;
        int i = 0;
        int sum = 0;
        int min = nums.length + 1;//理解这么设置的深层原因
        while(left < nums.length){
            if(i < nums.length && sum < s) sum += nums[i++];
            else sum -= nums[left++];

            if(sum >= s)min = Math.min(min, i-left);
        }
        if(min == nums.length+1)return 0;
        return min;
    }
}

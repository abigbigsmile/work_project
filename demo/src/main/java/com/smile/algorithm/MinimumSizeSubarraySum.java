package com.smile.algorithm;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int pos = 0;
        int sum = 0;
        int count = nums.length + 1;//理解这么设置的深层原因
        while(left < nums.length){
            if(pos < nums.length && sum < s){
                sum += nums[pos++];
            }else{
                sum -= nums[left++];
            }
            if(sum >= s)count = Math.min(count, pos-left);
        }
        if(count == nums.length+1)return 0;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(3, new int[]{1,1}));
    }
}

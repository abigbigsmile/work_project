package com.smile.algorithm;

import java.util.Arrays;

public class ThreeSumClosest_16 {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int res = threeSumClosest(nums, 1);
        System.out.println(res);
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3)return target;
        Arrays.sort(nums);
        //int res = target>0? Integer.MIN_VALUE : Integer.MIN_VALUE;
        int res = nums[0] + nums[1] + nums[2];
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i-1] == nums[i]) continue;
            int left=i+1, right=nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] +nums[right];
                if(sum == target)return sum;
                else if(sum > target){
                    while(left < right && nums[right-1] == nums[right] ) right--;
                    right--;
                }else{
                    while(left < right && nums[left+1] == nums[left] ) left++;
                    left++;
                }
                res = Math.abs(res-target) < Math.abs(sum-target)? res: sum;
            }
        }
        return res;
    }
}

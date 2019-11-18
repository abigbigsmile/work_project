package com.smile.algorithm_review;

import java.util.Arrays;
import java.util.HashSet;

public class ThreeSumClosest_16 {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0;i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1, right=nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == target) return target;
                else if(sum < target){
                    while (left+1<right && nums[left]==nums[left+1]) left++;
                    left++;
                }else {
                    while (left<right-1 && nums[right]==nums[right-1]) right--;
                    right--;
                }

                min = Math.abs(sum-target)<Math.abs(min-target)? sum : min;
            }
        }
        return min;
    }
}

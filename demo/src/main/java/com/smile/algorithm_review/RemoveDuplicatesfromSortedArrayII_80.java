package com.smile.algorithm_review;

public class RemoveDuplicatesfromSortedArrayII_80 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println();
    }


    public static int removeDuplicates(int[] nums) {
        int left = 0;
        for(int num : nums){
            if(left<2 || num>nums[left-2]) nums[left++] = num;
        }
        return left;
    }
}

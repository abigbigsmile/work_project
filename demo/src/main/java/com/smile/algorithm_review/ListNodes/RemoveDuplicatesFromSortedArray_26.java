package com.smile.algorithm_review.ListNodes;

public class RemoveDuplicatesFromSortedArray_26 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println(removeDuplicates(nums));
        System  .out.println(removeDuplicates_x(nums));
        System.out.println();
    }

    public static int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int left = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[i-1]){
                nums[left++] = nums[i];
            }
        }
        return left;
    }

    public static int removeDuplicates_x(int[] nums) {
        int left=0;
        for(int num : nums){
            if(left<1 || num>nums[left-1]) nums[left++] = num;
        }
        return left;
    }

}

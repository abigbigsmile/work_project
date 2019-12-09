package com.smile.algorithm_review.ListNodes;

public class RemoveElement_27{

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        removeElement(nums, 2);
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        int left = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
        return left;

    }
}

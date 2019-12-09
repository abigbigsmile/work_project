package com.smile.algorithm_review.SlidingWindow;

public class ContainsDuplicateII_219 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k=3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<=0) return false;
        for(int i=0; i<nums.length; i++){
            int left=i, right=i+1;
            while(right<nums.length){
                if(nums[right] == nums[left]){
                    if(right-left <= k) return true;
                    left=right;
                }
                right++;
            }
        }
        return false;
    }
}

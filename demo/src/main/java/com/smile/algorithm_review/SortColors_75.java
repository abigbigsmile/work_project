package com.smile.algorithm_review;

import static com.smile.sort.Utils.swap;

/**
 * 数组问题
 */
public class SortColors_75 {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println();
    }

    public static void sortColors(int[] nums) {
        int left=0, right=nums.length-1;
        int i=0;
        while(i<right){
            if(nums[i]==0)swap(nums, left++, i++);
            else if(nums[i]==2)swap(nums, right--, i);
            else i++;
        }
    }


}

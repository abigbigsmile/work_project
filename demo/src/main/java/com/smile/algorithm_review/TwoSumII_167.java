package com.smile.algorithm_review;

import java.util.Arrays;


/**
 * 双指针问题
 */
public class TwoSumII_167 {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println();
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers.length<2) return res;
        //Arrays.sort(numbers);
        int left = 0, right = numbers.length-1;
        while(left<right){
            if(numbers[left]+numbers[right]==target){
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }else if(numbers[left]+numbers[right]<target) left++;
            else right--;
        }
        return res;
    }
}

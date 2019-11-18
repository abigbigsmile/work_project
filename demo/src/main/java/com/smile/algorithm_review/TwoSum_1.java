package com.smile.algorithm_review;

import java.util.HashMap;

public class TwoSum_1 {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] res = twoSum(nums, target);
        System.out.println();
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hashMap.containsKey(target-nums[i])){
                res[0] = i;
                res[1] = hashMap.get(target-nums[i]);
                return res;
            }
            hashMap.put(nums[i], i);
        }
        return res;
    }
}

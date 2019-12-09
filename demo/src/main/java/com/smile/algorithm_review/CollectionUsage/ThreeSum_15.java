package com.smile.algorithm_review.CollectionUsage;

import java.util.*;

public class ThreeSum_15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            //优化，因为有序
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            HashSet<Integer> hashSet = new HashSet<>();
            for(int j=i+1; j<nums.length; j++){
                if(hashSet.contains(0-nums[i]-nums[j])){
                    res.add(Arrays.asList(nums[i], nums[j], 0-nums[i]-nums[j]));
                    //排除重复
                    while(j+1<nums.length && nums[j]==nums[j+1]) j++;
                }else {
                    hashSet.add(nums[j]);
                }
            }
        }
        return res;
    }
}

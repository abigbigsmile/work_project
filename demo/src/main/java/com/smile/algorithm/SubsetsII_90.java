package com.smile.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsetsWithDup(nums);
        System.out.println();
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, res, subList, 0);
        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> subList, int start){
        res.add(new ArrayList<Integer>(subList));
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            subList.add(nums[i]);
            backtrack(nums, res, subList, i+1);
            subList.remove(subList.size()-1);
        }
    }
}

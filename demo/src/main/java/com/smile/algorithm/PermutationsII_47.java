package com.smile.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_47 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,3};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println();
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(nums, res, tempList, used);
        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tempList, boolean[] used){
        if(tempList.size() == nums.length){
            res.add(new ArrayList(tempList));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i] || i>0&&nums[i]==nums[i-1]&&used[i-1]) continue;
            tempList.add(nums[i]);
            used[i] = true;
            backtrack(nums, res, tempList, used);
            tempList.remove(tempList.size()-1);
            used[i] = false;
        }
    }
}

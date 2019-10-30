package com.smile.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations_46 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println();
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        List<Integer> used = new ArrayList<>();
        helper(nums, res, 0, used);
        return res;

    }

    public static void helper(int[] nums, List<List<Integer>> res, int count, List<Integer> used){
        if(count == nums.length){
            List<Integer> list = new ArrayList<>(used);
            res.add(list);
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!used.contains(nums[i])){
                used.add(nums[i]);
                helper(nums, res, count+1, used);
                used.remove(used.size()-1);
            }
        }
    }
}

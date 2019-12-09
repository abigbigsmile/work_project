package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class SubsetsII_90 {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
//        List<List<Integer>> res = subsetsWithDup(nums);
        List<List<Integer>> res = subsetsWithDup_x(nums);
        System.out.println();
    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null) return res;
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }


    public static void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            helper(nums, i+1, res, list);
            list.remove(nums.length-1);
        }
    }


    public static List<List<Integer>> subsetsWithDup_x(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null) return res;
        res.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++){
            int size = res.size();
            for(int j=0; j<size; j++){
                List<Integer> temp = res.get(j);
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }
}

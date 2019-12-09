package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_47 {

    public static void main(String[] args) {
        int[] nums = {1,1,3};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println();
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        helper(nums, res, new ArrayList<>(), isVisited, 0);
        return res;
    }


    public static void helper(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] isVisited, int count){
        if(count==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1] && !isVisited[i-1]) continue;
            if(!isVisited[i]){
                list.add(nums[i]);
                isVisited[i] = true;
                helper(nums, res, list, isVisited, count+1);
                isVisited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}

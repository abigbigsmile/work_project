package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println();
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        boolean[] isVisited = new boolean[nums.length];
        helper(nums, res, new ArrayList<>(), isVisited, 0);
        return res;
    }

    public static void helper(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] isvisited, int count){
        if(count==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!isvisited[i]){
                list.add(nums[i]);
                isvisited[i] = true;
                helper(nums, res, list, isvisited, count+1);
                isvisited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}

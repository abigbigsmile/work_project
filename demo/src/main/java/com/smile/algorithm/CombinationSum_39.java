package com.smile.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println();
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //Arrays.sort(candidates);
        helper(res, new ArrayList<>(), 0, candidates, target, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> temp, int sum, int[] candidates, int target, int start){

        if(sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }else if(sum > target) return;
        else {
            for(int i=start; i<candidates.length; i++) {
                temp.add(candidates[i]);
                helper(res, temp, sum + candidates[i], candidates, target, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

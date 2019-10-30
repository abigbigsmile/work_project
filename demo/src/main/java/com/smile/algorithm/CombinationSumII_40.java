package com.smile.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println();
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), 0, candidates, target, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> temp, int sum, int[] candidates, int target, int start){

        if(sum > target) return;
        else if(sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }else {
            for(int i=start; i<candidates.length; i++) {
                if(i>start && candidates[i]==candidates[i-1]) continue;
                temp.add(candidates[i]);
                helper(res, temp, sum + candidates[i], candidates, target, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

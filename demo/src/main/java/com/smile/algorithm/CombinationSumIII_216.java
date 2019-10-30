package com.smile.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII_216 {

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3, 9);
        System.out.println();
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(),k, n, 0,1);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> temp, int k, int target, int sum, int start){

        if(sum > target || temp.size()>k) return;
        else if(sum == target && temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }else {
            for(int i=start; i<=9; i++) {
                temp.add(i);
                helper(res, temp,k, target, sum+i, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }


}

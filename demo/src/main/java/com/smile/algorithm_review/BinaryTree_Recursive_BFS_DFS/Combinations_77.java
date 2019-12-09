package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import com.smile.algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {


    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = combine(n, k);
        System.out.println();
    }


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<=0 || k<=0) return res;
        helper(n, k, 1, res, new ArrayList<>());
        return res;
    }

    public static void helper(int n, int k, int start, List<List<Integer>> res, List<Integer> list){
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<=n; i++){
            list.add(i);
            helper(n, k, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
}

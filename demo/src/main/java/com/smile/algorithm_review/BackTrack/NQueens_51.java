package com.smile.algorithm_review.BackTrack;

import java.util.*;

public class NQueens_51 {

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = solveNQueens(n);
        System.out.println();
    }

    public static List<List<String>> solveNQueens(int n){
        List<List<String>> res = new ArrayList<>();
        helper(n, new HashMap<>(), res, new boolean[n], 0);
        return res;
    }

    public static void helper(int n, HashMap<Integer, Integer> map, List<List<String>> res, boolean[] isExist, int level){
        if(level == n){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++) sb.append(".");
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++) {
                int col = map.get(i);
                sb.replace(col, col+1, "Q");
                temp.add(sb.toString());
                sb.replace(col, col+1, ".");
            }
            res.add(temp);
            return;
        }
        for(int col=0; col<n; col++){
            if(isExist[col])continue;
            boolean flag = true;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(Math.abs(level-entry.getKey()) == Math.abs(col-entry.getValue())) flag = false;
            }
            if(flag){
                map.put(level, col);
                isExist[col] = true;
                helper(n, map, res, isExist, level+1);
                isExist[col] = false;
                map.remove(level);
            }

        }
    }
}

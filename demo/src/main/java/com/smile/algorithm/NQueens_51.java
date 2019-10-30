package com.smile.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NQueens_51 {

    public static void main(String[] args) {
        //List<List<String>> res = solveNQueens(4);
        List<List<String>> res = solveNQueens_x(4);
        System.out.println();
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n<=0) return res;
        Map<Integer, Integer> pos = new HashMap<>();
        for(int i=0; i<n; i++){
            boolean[] isVisited = new boolean[n+1];
            isVisited[i] = true;
            pos.put(0,i);
            helper(0, res, isVisited , n, pos);
            pos.clear();
        }
        return res;
    }

    public static void helper(int row,List<List<String>> res, boolean[]isVisited, int n, Map<Integer, Integer> pos){
        if(row == n-1){
            List<String> temp = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++) sb.append(".");
            for(int i=0; i<n; i++){
                int p = pos.get(i);
                sb.replace(p, p+1, "Q");
                temp.add(sb.toString());
                sb.replace(p, p+1, ".");
            }
            res.add(temp);
        };
        for(int c=0; c<n; c++){
            if(isVisited[c]) continue;
            boolean flag = true;
            for(Map.Entry<Integer, Integer> entry : pos.entrySet()){
                if(Math.abs(row+1-entry.getKey()) == Math.abs(c-entry.getValue())) flag = false;
            }
            if(flag) {
                isVisited[c] = true;
                pos.put(row+1, c);
                helper(row+1,res, isVisited, n, pos);
                isVisited[c] = false;
                pos.remove(row+1);
            }
        }
    }

    public static List<List<String>> solveNQueens_x(int n){
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[2*n];
        boolean[] dia2 = new boolean[2*n];
        char[][] m = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                m[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        helper_x(m, 0, n, res, col, dia1, dia2, new ArrayList<Integer>());
        return res;
    }

    public static void helper_x(char[][] m, int curRow, int n, List<List<String>> res, boolean[]col, boolean[] dia1, boolean[] dia2, List<Integer> pos){
        if(curRow == n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                temp.add(String.valueOf(m[i]));
            }
            res.add(temp);
            return;
        }
        for(int i=0; i<n; i++){
            //如果位置有效
            if(!col[i] && !dia1[curRow+i] && !dia2[curRow-i+n-1]){
                col[i] = true;
                dia1[curRow+i] = true;
                dia2[curRow-i+n-1] = true;
                pos.add(i);
                m[curRow][i] = 'Q';
                helper_x(m, curRow+1, n, res, col, dia1, dia2, pos);
                m[curRow][i] = '.';
                pos.remove(pos.size()-1);
                col[i] = false;
                dia1[curRow+i] = false;
                dia2[curRow-i+n-1] = false;
            }
        }
    }

}

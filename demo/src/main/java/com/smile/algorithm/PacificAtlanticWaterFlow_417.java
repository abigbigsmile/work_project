package com.smile.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow_417 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,   2 ,  3,  5},
                {3,   2,   3 , 4 ,4},
                {2 ,  4 , 5 , 3 , 1},
                {6 ,7 , 1 ,  4 ,  5},
                {5 ,1  , 1 ,  2 ,  4}
        };
        List<List<Integer>> res = pacificAtlantic(matrix);
        System.out.println();
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix==null || matrix.length==0) return res;
        int x = matrix.length, y = matrix[0].length;
        //分别用来表示两片海洋从边界开始可以连通的区域，相交处则表示能够同时流出两片海洋
        boolean[][] pacific = new boolean[x][y];
        boolean[][] atlantic  = new boolean[x][y];
        //左，右
        for(int i=0; i<x; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, y-1);
        }
        //上、下
        for(int i=0; i<y; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, x-1, i);
        }

        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(pacific[i][j] && atlantic[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    public static void dfs(int[][] matrix, boolean[][] isVisited, int height, int x, int y){
        if(x<0 || x>matrix.length-1 || y<0 || y>matrix[0].length-1 || isVisited[x][y] || matrix[x][y] < height) return;
        isVisited[x][y] = true;
        dfs(matrix, isVisited, matrix[x][y], x, y-1);
        dfs(matrix, isVisited, matrix[x][y], x-1, y);
        dfs(matrix, isVisited, matrix[x][y], x+1, y);
        dfs(matrix, isVisited, matrix[x][y], x, y+1);
    }

}

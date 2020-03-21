package com.smile.nowcoder.second;

import java.util.ArrayList;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/18 0:24
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Nineteen {

    // 递归
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList();
        if(matrix == null) return res;
        helper(res, matrix, 0, 0, matrix.length-1, matrix[0].length-1);
        return res;
    }


    public void helper(ArrayList<Integer> res, int[][] matrix, int startx, int starty, int endx, int endy){
        if(startx>endx || starty>endy) return;
        if(startx==endx && starty==endy){
            res.add(matrix[startx][starty]);
            return;
        }
        for(int i=starty; i<=endy; i++) res.add(matrix[startx][i]);
        for(int i=startx+1; i<=endx; i++) res.add(matrix[i][endy]);
        if(startx != endx) for(int i=endy-1; i>=starty; i--) res.add(matrix[endx][i]);
        if(starty != endy) for(int i=endx-1; i>startx; i--) res.add(matrix[i][starty]);
        helper(res, matrix, startx+1, starty+1, endx-1, endy-1);
    }

    // 非递归
    public ArrayList<Integer> printMatrix_x(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            // 左到右
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            // 从上到下
            for (int i = top + 1; i <= bottom; i++) res.add(matrix[i][right]);
            // 从右到左
            if (top != bottom) for (int i = right - 1; i >= left; i--) res.add(matrix[bottom][i]);
            // 从下到上
            if (left != right) for (int i = bottom - 1; i > top; i--) res.add(matrix[i][left]);
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }

}

package com.smile.algorithm;

import java.util.LinkedList;

public class UniquePaths_62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }

    //回溯算法，此题同样可以使用动态规划算法来进行求解
    public static int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;
        return helper(0, 0, m, n);
    }

    public static int helper(int x, int y, int m, int n){
        int res = 0;
        if(x==m-1 && y==n-1) return 1;
        if(x<0 || x>=m || y<0 || y>=n) return 0;
        res += helper(x, y+1, m, n);
        res += helper(x+1, y, m, n);
        return res;
    }
}

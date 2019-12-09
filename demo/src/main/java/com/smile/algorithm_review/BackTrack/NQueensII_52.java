package com.smile.algorithm_review.BackTrack;

public class NQueensII_52 {

    public static void main(String[] args) {
        int n = 4;
        int res = totalNQueens(n);
        System.out.println();
    }


    public static int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[2*n];
        boolean[] dia2 = new boolean[2*n];
        return helper(n, col, dia1, dia2, 0);
    }

    public static int helper(int n, boolean[] col, boolean[] dia1, boolean[] dia2, int row){
        int res = 0;
        if(row==n-1) return 1;
        for(int c=0; c<n; c++){
            if(!col[c] || !dia1[c] || !dia2[c]){
                col[c] = true;
                dia1[row+c] = true;
                dia1[row-c+n-1] = true;
                res += helper(n, col, dia1, dia2, row+1);
                dia1[row-c+n-1] = false;
                dia1[row+c] = false;
                col[c] = false;
            }
        }
        return res;
    }
}

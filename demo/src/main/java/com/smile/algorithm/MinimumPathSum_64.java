package com.smile.algorithm;

public class MinimumPathSum_64 {

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length==0) return 0;
        return helper(grid, 0, 0);
    }

    public static int helper(int[][] grid, int x, int y){
        if(x==grid.length-1 && y==grid[0].length-1) return grid[x][y];
        if(x==grid.length-1) return grid[x][y] + helper(grid, x, y+1);
        else if(y==grid[0].length-1) return grid[x][y] + helper(grid, x+1, y);
        else return grid[x][y] + Math.min(helper(grid, x, y+1), helper(grid, x+1, y));
    }

    public static int minPathSum_x(int[][] grid) {
        if(grid == null || grid.length==0) return 0;
        int[] dp = new int[grid.length * grid[0].length + 1];
        for(int i=grid.length-1; i>=0; i--){
            for(int j=grid[0].length; j>=0; j++){
               // dp[i/3 + j%3] = Math.min(grid)
            }
        }
        return 0;
    }

}

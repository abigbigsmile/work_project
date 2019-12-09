package com.smile.DynamicProgramming;

public class MinimumPathSum_64 {

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
//        System.out.println(minPathSum(grid));
        System.out.println(minPathSum_x(grid));
    }

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else if(i==0) dp[i][j] = dp[i][j-1] + grid[i][j];
                else if(j==0) dp[i][j] = dp[i-1][j] + grid[i][j];
                else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }


    public static int minPathSum_x(int[][] grid) {
        return helper(grid, 0, 0);
    }

    public static int helper(int[][] grid, int x, int y){
        if(x==grid.length-1 && y==grid[0].length-1);
        int sum = grid[x][y];
        int right = Integer.MAX_VALUE;
        int bottom = Integer.MAX_VALUE;
        if(y+1<grid[0].length) right = helper(grid, x, y+1);
        if(x+1<grid.length) bottom = helper(grid, x+1, y);
        if(right==Integer.MAX_VALUE && bottom==Integer.MAX_VALUE) return sum;
        sum += Math.min(right, bottom);
        return sum;
    }
}




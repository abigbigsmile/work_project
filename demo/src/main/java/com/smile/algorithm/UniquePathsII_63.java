package com.smile.algorithm;

public class UniquePathsII_63 {

    public static void main(String[] args) {
        int[][] obs = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(obs));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0 || obstacleGrid[0][0]==1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1) continue;
                if(i>0 && obstacleGrid[i-1][j]!=1) dp[i][j] += dp[i-1][j];
                if(j>0 && obstacleGrid[i][j-1]!=1) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

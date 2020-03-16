package com.smile.algorithm_review.DynamicProgramming;

public class OnesAndZeroes_474 {

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];
        int[] init = getZerosOnes(strs[0]);
        for(int i=init[0]; i<=m; i++){
            for(int j=init[1]; j<=n; j++){
                dp[0][i][j] = 1;
            }
        }

        for(int i=1; i<strs.length; i++){
            int count[] = getZerosOnes(strs[i]);
            for(int j=0; j<=m; j++){
                for(int k=0; k<=n; k++){
                    if(j<count[0] || k<count[1]) dp[i][j][k] = dp[i-1][j][k];
                    else dp[i][j][k] = Math.max(dp[i-1][j][k], 1+dp[i-1][j-count[0]][k-count[1]]);
                }
            }
        }

        return dp[strs.length-1][m][n];

    }

    public static int[] getZerosOnes(String s){
        int[] count = new int[2];
        for(char c : s.toCharArray()) count[c-'0']++;
        return count;
    }
}

package com.smile.algorithm;

public class OnesAndZeroes_474 {

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int zeros = 5, ones = 3;
        System.out.println(findMaxForm(strs, zeros, ones));
        System.out.println(findMaxForm_x(strs, zeros, ones));
        System.out.println(findMaxForm_xx(strs, zeros, ones));
    }

    private static int[] getZeroOne(String s){
        int[] count = new int[2];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0') count[0]++;
            else count[1]++;
        }
        return count;
    }

    //下面因为边界为[0, strs.length-1],所以要初始化第0层
    private static int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];

        //初始化
        int[] count = getZeroOne(strs[0]);
        for(int i=m; i>=count[0]; i--){
            for(int j=n; j>=count[1]; j--){
                dp[0][i][j] = 1;
            }
        }
        dp[0][0][0] =1;

        for(int k=1; k<strs.length; k++){
            count = getZeroOne(strs[k]);
            for(int i=0; i<=m; i++){
                for(int j=0; j<=n; j++){
                    if(i>=count[0] && j>=count[1]) dp[k][i][j] = Math.max(dp[k-1][i][j], 1+dp[k-1][i-count[0]][j-count[1]]);
                    else dp[k][i][j] = dp[k-1][i][j];
                }
            }
        }
        return dp[strs.length-1][m][n];
    }

    //边界为[0, strs.length]，所以第0层全初始化为0
    private static int findMaxForm_x(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        int[] count = {0, 0};
        for(int k=0; k<=strs.length; k++){
            if(k>0) count = getZeroOne(strs[k-1]);
            for(int i=0; i<=m; i++){
                for(int j=0; j<=n; j++){
                    if(k==0) dp[k][i][j] = 0;
                    else if(i>=count[0] && j>=count[1]) dp[k][i][j] = Math.max(dp[k-1][i][j], 1+dp[k-1][i-count[0]][j-count[1]]);
                    else dp[k][i][j] = dp[k-1][i][j];
                }
            }
        }
        return dp[strs.length][m][n];
    }

    //空间复杂度优化
    private static int findMaxForm_xx(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String s : strs){
            int[] count = getZeroOne(s);
            for(int i=m; i>=count[0]; i--) {
                for(int j=n; j>=count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-count[0]][j-count[1]]);
                }
            }
        }
        return dp[m][n];
    }
}

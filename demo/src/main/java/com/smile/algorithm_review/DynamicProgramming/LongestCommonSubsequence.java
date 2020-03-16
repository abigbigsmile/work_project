package com.smile.algorithm_review.DynamicProgramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String a = "BDCABA";
        String b = "ABCBDAB";
        System.out.println(lcs(a, b));
        System.out.println(lcs_x(a, b));
    }

    public static int lcs(String a, String b){
        if(a==null || a.length()==0 || b==null || b.length()==0) return 0;
        if(a.charAt(0) == b.charAt(0)) return 1+lcs(a.substring(1), b.substring(1));
        else return Math.max(lcs(a.substring(1), b), lcs(a, b.substring(1)));
    }

    public static int lcs_x(String a, String b){
        int[][] dp = new int[a.length()+1][b.length()+1];


        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[a.length()][b.length()];
    }
}

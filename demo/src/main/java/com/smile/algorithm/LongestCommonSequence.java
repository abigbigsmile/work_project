package com.smile.algorithm;

public class LongestCommonSequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestCommonSequence("helloworld", "loop"));
        System.out.println(lengthOfLongestCommonSequence("acbds", "abedks"));
        System.out.println(lengthOfLongestCommonSequence_x("helloworld", "loop"));
        System.out.println(lengthOfLongestCommonSequence_x("acbds", "abedks"));
    }

    public static int lengthOfLongestCommonSequence(String s1, String s2){
        return helper(s1, s2, s1.length()-1, s2.length()-1);
    }

    //递归
    public static int helper(String s1, String s2, int pos1, int pos2){
        if(pos1 < 0 || pos2 < 0) return 0;
        if(s1.charAt(pos1) == s2.charAt(pos2)) return 1+helper(s1, s2, pos1-1, pos2-1);
        else return Math.max(helper(s1, s2, pos1-1, pos2), helper(s1, s2, pos1, pos2-1));
    }

    /**
     * 动态规划：两个状态，dp(m, n)表示[0, m]和[0, n]的两个字串的最大公共子序列
     * if s1[m] == s2[n], dp(m, n) = 1 + dp(m+1, n+1)
     * else dp(m, n) = max(dp(m, n+1), dp(m+1, n))
     */
    public static int lengthOfLongestCommonSequence_x(String s1, String s2){
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i=0; i<s1.length(); i++) dp[i][0] = s1.charAt(i)==s2.charAt(0)? 1 : 0;

        for(int i=0; i<s2.length(); i++) dp[0][i] = s2.charAt(i)==s1.charAt(0)? 1 : 0;


        for(int m=1; m<s1.length(); m++){
            for (int n=1; n<s2.length(); n++){
                if(s1.charAt(m) == s2.charAt(n)){
                    dp[m][n] = 1 + dp[m-1][n-1];
                }else{
                    dp[m][n] = Math.max(dp[m][n-1], dp[m-1][n]);
                }
            }
        }
        return dp[s1.length()-1][s2.length()-1];

    }




}

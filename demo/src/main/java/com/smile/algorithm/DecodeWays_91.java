package com.smile.algorithm;

public class DecodeWays_91 {

    public static void main(String[] args) {
        String s = "12";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        int[] dp = new int[s.length()+1];

        //dp[i] 表示长度为i的字符串的最大Decode Ways
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'? 0 : 1;
        for(int i=2; i<=s.length(); i++){
            int pre = s.charAt(i-2) - '0';
            int cur = s.charAt(i-1) - '0';
            if(cur>=1 && cur<=9) dp[i] += dp[i-1];
            if(pre*10+cur>=10 && pre*10+cur<=26) dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }


}

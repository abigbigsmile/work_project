package com.smile.algorithm_review.DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class WordBreak_139 {


    public static void main(String[] args) {
        String[] words = {"apple", "pen"};
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList(words);
        System.out.println(wordBreak(s, wordDict));
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[][] dp = new boolean[wordDict.size()][s.length()+1];
        String firstWord = wordDict.get(0);
        for(int j=firstWord.length(); j<=s.length(); j++){
            for(int k=0; k*firstWord.length()<=j; k++){
                String temp = s.substring(0, j).replaceAll(firstWord, "");
                if(temp.length()==0) dp[0][j] = true;
            }
        }

        for(int i=1; i<wordDict.size(); i++){
            String word = wordDict.get(i);
            for(int j=0; j<=s.length(); j++){
                for(int k=0; k*word.length()<=j; k++){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-k*word.length()];
                }
            }
        }

        return dp[wordDict.size()-1][s.length()];
    }


}

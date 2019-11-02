package com.smile.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("apple", "pen");
        String s = "applepenapple";
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>();
        for (String word : wordDict) set.add(word);

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}

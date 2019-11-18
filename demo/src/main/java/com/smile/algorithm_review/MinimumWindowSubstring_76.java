package com.smile.algorithm_review;

import java.lang.management.ManagementFactory;
import java.util.HashMap;

public class MinimumWindowSubstring_76 {

    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";
        System.out.println(minWindow(S, T));
    }

    public static String minWindow(String s, String t) {
        String res = "";
        if(s.length()==0 || t.length()==0 || s.length()<t.length()) return res;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char c : t.toCharArray()) hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
        int left=0, right=0;
        int counter = t.length();
        int min = Integer.MAX_VALUE;
        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            if(hashMap.containsKey(c)){
                hashMap.put(c, hashMap.get(c)-1);
                if(hashMap.get(c)>=0) counter--;
            }
            while(counter==0){
                char tempc = s.charAt(left);
                if(hashMap.containsKey(tempc)){
                    hashMap.put(tempc, hashMap.get(tempc)+1);
                    if(hashMap.get(tempc)>0) counter++;
                }
                if(min > right-left){
                    res = s.substring(left, right);
                    min = right-left;
                }
                left++;
            }
        }
        return res;
    }
}

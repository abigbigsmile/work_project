package com.smile.algorithm_review;

/**
 * 查找问题
 */
public class ValidAnagram_242 {

    public static void main(String[] args) {
//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] temp = new int[128];
        for(char c : s.toCharArray()) temp[c]++;
        for(char c : t.toCharArray()) {
            temp[c]--;
            if(temp[c]<0) return false;
        }
        return true;
    }
}

package com.smile.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ValidAnagram_242 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) arr[s.charAt(i) - 'a']++;
        for(int i=0; i<t.length(); i++) arr[t.charAt(i) - 'a']--;
        for(int i=0; i<arr.length; i++) if(arr[i] != 0)return false;
        return true;
    }
}

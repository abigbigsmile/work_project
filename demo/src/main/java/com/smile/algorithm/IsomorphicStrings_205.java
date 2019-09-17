package com.smile.algorithm;

public class IsomorphicStrings_205 {

    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[128], m2 = new int[128];
        for(int i=0; i<s.length(); i++){
            m1[s.charAt(i)] = m2[t.charAt(i)] = i;
        }
        for(int i=0; i<s.length();i++){
            if(m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
        }
        return true;
    }
}

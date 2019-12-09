package com.smile.algorithm_review.CollectionUsage;

import jdk.nashorn.internal.ir.CatchNode;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings_205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic_x("ab", "aa"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character, Character> hashMap = new HashMap<>();
        HashSet<Character> hashSet = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(hashMap.containsKey(c)){
                if(!hashSet.contains(hashMap.get(c)))return false;
                if(!hashMap.get(c).equals(t.charAt(i))) return false;
            }else{
                if(hashSet.contains(t.charAt(i)))return false;
                hashMap.put(c, t.charAt(i));
                hashSet.add(t.charAt(i));
            }
        }
        return true;
    }


    // 如果建立对应关系，注意思考其中的i+1 （范例：s="aa", t="ab")
    public static boolean isIsomorphic_x(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] srr = new int[256], trr = new int[256];
        for(int i=0; i<s.length(); i++){
            if(srr[s.charAt(i)] != trr[t.charAt(i)]) return false;
            srr[s.charAt(i)] = i+1;
            trr[t.charAt(i)] = i+1;
        }
        return true;
    }

    public static boolean isIsomorphic_xx(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] srr = new int[256], trr = new int[256];
        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(srr[sc]==0 && trr[tc]==0){
                srr[sc] = tc;
                trr[tc] = sc;
            }else{
                if(srr[tc]!=trr[sc])return false;
            }
        }
        return true;
    }
}

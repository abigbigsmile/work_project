package com.smile.algorithm_review;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class WordPattern_290 {

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern(pattern, str));
        System.out.println(wordPattern_x(pattern, str));
    }


    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.trim().split(" ");
        if(pattern.length()!=words.length) return false;

        TreeMap<Character, String> pMap = new TreeMap<>();
        TreeMap<String, Character> sMap = new TreeMap<>();
        for(int i=0; i<pattern.length(); i++){
            pMap.put(pattern.charAt(i), words[i]);
            sMap.put(words[i], pattern.charAt(i));
        }
        if(pMap.size()!=sMap.size()) return false;
        for(char c : pattern.toCharArray()){
            String word = pMap.get(c);
            if(sMap.get(word)!=c) return false;
        }
        return true;
    }

    public static boolean wordPattern_x(String pattern, String str) {
        String[] words = str.trim().split(" ");
        if(pattern.length() != words.length) return false;
        HashMap<Character, String> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            if(hashMap.containsKey(c)){
                //如果hashMap包含c，但是c的word不等于words[i],return false
                if(!hashMap.get(c).equals(words[i])) return false;
            }else{
                //如果不存在，但是hashSet存在，return false
                if(hashSet.contains(words[i])) return false;
                hashMap.put(c, words[i]);
                hashSet.add(words[i]);
            }
        }
        return true;
    }
}

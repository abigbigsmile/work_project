package com.smile.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in
 * words exactly once and without any intervening characters
 * https://blog.csdn.net/xiaoguaihai/article/details/84780768
 */

public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        String[] l = {"word","good","best","word"};
        System.out.println(findSubstring("wordgoodgoodgoodbestword", l));
        System.out.println(findSubstring_x("wordgoodgoodgoodbestword", l));
    }

    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (S == null || S.length() == 0 || L == null || L.length == 0)
            return res;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            if (map.containsKey(L[i])) {
                map.put(L[i], map.get(L[i]) + 1);
            } else {
                map.put(L[i], 1);
            }
        }
        int len = L[0].length();
        for (int i = 0; i < len; i++) {
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            int count = 0;
            int left = i;
            for (int j = i; j <= S.length() - len; j += len) {
                String str = S.substring(j, j + len);

                if (map.containsKey(str)) {
                    if (curMap.containsKey(str))
                        curMap.put(str, curMap.get(str) + 1);
                    else
                        curMap.put(str, 1);
                    if (curMap.get(str) <= map.get(str))
                        count++;
                    else {
                        while (curMap.get(str) > map.get(str)) {
                            String temp = S.substring(left, left + len);
                            if (curMap.containsKey(temp)) {
                                curMap.put(temp, curMap.get(temp) - 1);
                                if (curMap.get(temp) < map.get(temp))
                                    count--;
                            }
                            left += len;
                        }
                    }
                    if (count == L.length) {
                        res.add(left);
                        //if(left<)
                        String temp = S.substring(left, left + len);
                        if (curMap.containsKey(temp))
                            curMap.put(temp, curMap.get(temp) - 1);
                        count--;
                        left += len;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left = j + len;
                }
            }
        }
        return res;
    }

    public static List<Integer> findSubstring_x(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return list;
        Map<String, Integer> preMap = new HashMap<>();
        for(String word : words){
            if(preMap.containsKey(word))preMap.put(word, preMap.get(word)+1);
            else preMap.put(word, 1);
        }
        int len = words[0].length();
        for(int i=0; i<len; i++){
            Map<String, Integer> winMap = new HashMap<>();
            int left = i;
            int count = 0;
            for(int j=i; j+len <= s.length(); j+=len){
                String subStr = s.substring(j, j+len);
                if(preMap.containsKey(subStr)){
                    if(winMap.containsKey(subStr)){
                        winMap.put(subStr, winMap.get(subStr)+1);
                    }else{
                        winMap.put(subStr, 1);
                    }
                    if(winMap.get(subStr) <= preMap.get(subStr)){
                        count ++;
                    }else{
                        //当winMap中subStr个数比preMap不能串联多时，表示
                        while(winMap.get(subStr) > preMap.get(subStr)){
                            String temp = s.substring(left, left+len);
                            if(winMap.containsKey(temp)){
                                winMap.put(temp, winMap.get(temp)-1);
                                if(winMap.get(temp) < preMap.get(temp))count --;
                            }
                            left += len;
                        }
                    }

                    if(count == words.length){
                        list.add(left);
                        String temp =  s.substring(left, left+len);
                        if(winMap.containsKey(temp))winMap.put(temp, winMap.get(temp)-1);
                        count--;
                        left += len;
                    }
                }else{
                    left = j+len;
                    count = 0;
                    winMap.clear();
                }


            }
        }
        return list;
    }


}

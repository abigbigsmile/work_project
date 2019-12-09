package com.smile.algorithm_review.ListNodes;

import java.util.*;

/**
 * 滑动窗口模板
 */
public class FindAllAnagramsinAString_438 {

    public static void main(String[] args) {
        String s = "cbaebabacd",  p = "abc";
        List<Integer> res = findAnagrams(s, p);
//        List<Integer> res = findAnagrams_x(s, p);
//        List<Integer> res = findAnagrams_xx(s, p);
        System.out.println();
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length()<p.length()) return res;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char c : p.toCharArray()) hashMap.put(c, hashMap.getOrDefault(c, 0)+1);

        int counter = hashMap.size();
        int left = 0, right = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            if(hashMap.containsKey(c)){
                hashMap.put(c, hashMap.get(c)-1);
                if(hashMap.get(c)==0) counter--;
            }
            while(counter==0){
                if(right-left==p.length()) res.add(left);
                char temp = s.charAt(left);
                if(hashMap.containsKey(temp)){
                    hashMap.put(temp, hashMap.get(temp)+1);
                    if(hashMap.get(temp)>0) counter++;
                }
                left++;
            }
        }
        return res;
    }

    public static List<Integer> findAnagrams_x(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0, end = 0;

        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;

            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }

        }
        return result;
    }


    public static List<Integer> findAnagrams_xx(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            if (count == 0) {
                list.add(left);
            }

            if (right - left == p.length() ) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return list;
    }
}

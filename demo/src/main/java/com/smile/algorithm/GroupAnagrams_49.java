package com.smile.algorithm;

import java.util.*;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        List<List<String>> lists_x = groupAnagrams_x(strs);
        System.out.println();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] crr = s.toCharArray();
            Arrays.sort(crr);
            String tempStr = String.valueOf(crr);
            List<String> list = map.getOrDefault(tempStr, new ArrayList<>());
            list.add(s);
            map.put(tempStr, list);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams_x(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] arr = new int[26];
            for(int i = 0;i<s.length();i++){
                arr[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(arr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key,tempList);
        }
        return new LinkedList<>(map.values());
    }
}

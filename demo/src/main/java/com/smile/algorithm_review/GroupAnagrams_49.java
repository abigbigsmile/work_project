package com.smile.algorithm_review;

import java.util.*;

/**
 * 善于利用集合类
 */
public class GroupAnagrams_49 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> res = groupAnagrams(strs);
        List<List<String>> res = groupAnagrams_xx(strs);
        System.out.println();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String , List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String tempStr = String.valueOf(temp);
            if(map.containsKey(tempStr)){
                map.get(tempStr).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(tempStr, list);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    //优化版
    public static List<List<String>> groupAnagrams_x(String[] strs) {
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

    //使用hash
    public static List<List<String>> groupAnagrams_xx(String[] strs) {

        HashMap<String,List<String>> hm = new HashMap<String,List<String>>();

        for(int i=0; i<strs.length; i++){
            String eachString = strs[i];

            //only lower-case letters. so array of size 26 is enough
            int[] counter = new int[26];

            //Iterate the string and increment corresponding index
            //char - 'a' , so the index will be between 0 and 25
            for(int j=0; j<eachString.length(); j++)
                counter[eachString.charAt(j)-'a']++;

            //Now iterate thorugh the counter array and construct the hash
            //Eg: cat becomes 1a1c1t. caabbt becomes 2a2b1c1t
            StringBuilder sb = new StringBuilder("");
            for(int j=0; j<26; j++){
                if(counter[j]>0){
                    sb.append(counter[j]);
                    sb.append((char) ('a'+j));
                }
            }

            String hash = sb.toString();

            //Chech if an entry exists in hash table already, else add a new one
            if(!hm.containsKey(hash))
                hm.put(hash,new LinkedList<String>());

            //Add this string to the list pointed by hash
            hm.get(hash).add(eachString);
        }

        return new LinkedList<List<String>>(hm.values());
    }
}

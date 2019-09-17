package com.smile.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency_451 {

    public static void main(String[] args) {
        System.out.println(frequencySort("charactercount"));
        System.out.println(frequencySort_x("charactercount"));
        System.out.println(frequencySort_xx("charactercount"));


    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] list = new ArrayList[s.length() + 1];
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(list[entry.getValue()] == null) list[entry.getValue()] = new ArrayList<>();
            list[entry.getValue()].add(entry.getKey());
        }

        StringBuffer sb = new StringBuffer();
        for(int i=list.length-1; i>=0; i--){
            if(list[i] != null){
                for(char c : list[i]){
                    for(int j=0; j<map.get(c); j++) sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static String frequencySort_x(String s) {
        if(s.length() < 3)
            return s;
        int max = 0;
        int[] map = new int[256];
        for(char ch : s.toCharArray()) {
            map[ch]++;
            max = Math.max(max,map[ch]);
        }
        String[] buckets = new String[max + 1]; // create max buckets
        for(int i = 0 ; i < 256; i++) { // join chars in the same bucket
            String str = buckets[map[i]];
            if(map[i] > 0)
                buckets[map[i]] = (str == null) ? "" + (char)i : (str + (char) i);
        }
        StringBuilder strb = new StringBuilder();
        for(int i = max; i >= 0; i--) { // create string for each bucket.
            if(buckets[i] != null)
                for(char ch : buckets[i].toCharArray())
                    for(int j = 0; j < i; j++)
                        strb.append(ch);
        }
        return strb.toString();
    }

    public static String frequencySort_xx(String s) {
        int[] irr = new int[128];
        char[] crr = s.toCharArray();
        int max = 0;
        //将字符以及字符对应的个数存进数组中，数组下标代表个数
        for(char c : crr){
            irr[c] ++;
            max = Math.max(max, irr[c]);
        }
        String[] srr = new String[max + 1];

        for(int i=0; i<irr.length; i++){
            if(irr[i] == 0)continue;
            String preStr = srr[irr[i]]; //原来可能已经有字符了
            srr[irr[i]] = (preStr == null)? ""+(char)i : preStr+(char)i;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=max; i>=0; i--){
            if(srr[i] != null){
                for(char c : srr[i].toCharArray()){
                    for(int j=0; j<i; j++) sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}

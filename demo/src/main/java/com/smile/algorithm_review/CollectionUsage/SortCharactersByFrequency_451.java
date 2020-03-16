package com.smile.algorithm_review.CollectionUsage;

import java.util.*;

public class SortCharactersByFrequency_451 {

    public static void main(String[] args) {
        String s = "aaaccc";
        System.out.println(frequencySort(s));
        System.out.println(frequencySort_x(s));
        System.out.println(frequencySort_xx(s));
    }

    //使用hashmap
    public static String frequencySort(String s) {
        if(s==null || s.isEmpty()) return "";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char c : s.toCharArray()) hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
        List<Map .Entry<Character, Integer>> wrapList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(wrapList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : wrapList){
            int count = entry.getValue();
            while(count-->0) sb.append(entry.getKey());
        }
        return sb.toString();
    }

    //使用原生数组
    public static String frequencySort_x(String s){
        int[] countArray = new int[128];
        int max = 0;
        for(char c : s.toCharArray()) {
            countArray[c]++;
            max = Math.max(max, countArray[c]);
        }

        String[] res = new String[max+1];
        for(int i=0; i<countArray.length; i++){
            if(countArray[i]==0) continue;
            String temp = res[countArray[i]];
            res[countArray[i]] = (temp==null) ? ""+(char)i : temp+(char)i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=res.length-1; i>=0; i--) {
            if(res[i]==null) continue;
            for(char c : res[i].toCharArray()){
                int count=i;
                while(count-->0) sb.append(c);
            }
        }
        return sb.toString();
    }

    //使用PriorityQueue

    public static String frequencySort_xx(String s){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char c : s.toCharArray()) hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
        /*
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        */
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        for(Map.Entry<Character, Integer> entry : hashMap.entrySet()) queue.offer(entry);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Map.Entry<Character, Integer> entry = queue.poll();
            int count = entry.getValue();
            while(count-->0) sb.append(entry.getKey());
        }
        return sb.toString();
    }

}

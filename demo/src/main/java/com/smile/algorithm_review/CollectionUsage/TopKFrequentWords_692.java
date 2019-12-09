package com.smile.algorithm_review.CollectionUsage;

import java.util.*;

public class TopKFrequentWords_692 {

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> res = topKFrequent(words, k);
        System.out.println();
    }

    public static List<String> topKFrequent(String[] words, int k) {
        /*
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue()!=o2.getValue()){
                    return o1.getValue()-o2.getValue();
                }else{
                    return o2.getKey().compareTo(o1.getKey());
                }
            }
        });
        */
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a,b)-> a.getValue()==b.getValue()? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0)+1);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            priorityQueue.offer(entry);
            if(priorityQueue.size()>k) priorityQueue.poll();
        }
        List<String> res = new ArrayList<>();
        while(!priorityQueue.isEmpty()) res.add(0, priorityQueue.poll().getKey());
        return res;
    }

}

package com.smile.algorithm;

import java.util.*;

public class TopKFrequentWords_692 {

    public static void main(String[] args) {
        String[] strings = {"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequent(strings, 2);
        System.out.println();
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        for(String word : words) freqMap.put(word, freqMap.getOrDefault(word, 0)+1);

        PriorityQueue<Map.Entry<String, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue())? b.getKey().compareTo(a.getKey()) : Integer.compare(a.getValue(), b.getValue()));

        for(Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(entry);
            if(maxHeap.size() > k) maxHeap.poll();
        }

        while(!maxHeap.isEmpty()) ((LinkedList<String>) res).push(maxHeap.poll().getKey());
        return res;
    }
}

package com.smile.algorithm_review.CollectionUsage;

import java.util.*;

public class TopKFrequentElements_347 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,4,4,4,5};
        int k = 2;
//        List<Integer> res = topKFrequent(nums, k);
        List<Integer> res = topKFrequent_x(nums, k);
        System.out.println();
    }

    //这个是错误的
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==0 || k<=0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
            if(priorityQueue.size()>k) priorityQueue.poll();
        }
        for(Map.Entry<Integer, Integer> entry : priorityQueue) res.add(entry.getKey());
        return res;
    }


    public static List<Integer> topKFrequent_x(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(int key : map.keySet()){
            int value = map.get(key);
            if(bucket[value]==null) bucket[value] = new ArrayList<>();
            bucket[value].add(key);
        }

        for(int i=bucket.length-1; i>=0&&res.size()<=k; i--){
            if(bucket[i]!=null) res.addAll(bucket[i]);
        }

        return res.subList(0, k);
    }

}

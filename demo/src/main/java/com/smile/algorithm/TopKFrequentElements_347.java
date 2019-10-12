package com.smile.algorithm;

import java.util.*;

public class TopKFrequentElements_347 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,5,5};
        List<Integer> list = topKFrequent(nums, 2);
        //List<Integer> list = topKFrequent_x(nums, 2);
        System.out.println();
    }

    //使用优先队列
    private static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1); //计算频率

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(), b.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            priorityQueue.add(entry);
            if(priorityQueue.size() > k) priorityQueue.poll();
        }
        List<Integer> res = new LinkedList<>();
        while(!priorityQueue.isEmpty()){
            ((LinkedList<Integer>) res).push(priorityQueue.poll().getKey());
        }
        return res;
    }

    //使用桶排序
    public static List<Integer> topKFrequent_x(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        List<Integer>[] bucket = new List[nums.length+1];
        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for(int pos=bucket.length-1; pos>=0 && res.size()<k; pos--){
            if(bucket[pos] != null){
                res.addAll(bucket[pos]);
            }
        }
        return res.subList(0,k);
    }

    //使用TreeMap进行排序
    public List<Integer> topKFrequent_xx(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1); //计算各个num对应频率

        for(int num : map.keySet()){
            int value = map.get(num);
            if(!freqMap.containsKey(value)) freqMap.put(value, new ArrayList<Integer>());
            freqMap.get(value).add(num);
        }

        while(res.size() < k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }

        return res;


    }
}

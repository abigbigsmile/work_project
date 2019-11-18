package com.smile.algorithm_review;

import java.util.PriorityQueue;

public class ContainsDuplicateIII_220 {

    public static void main(String[] args) {

    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b)->b-a);
        for(int num : nums){
            if(priorityQueue.size()>k) priorityQueue.poll();

        }

    }
}

package com.smile.algorithm_review.SlidingWindow;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class ContainsDuplicateIII_220 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k=3, t=0;
        System.out.println(containsNearbyAlmostDuplicate_x(nums, k, t));

    }

    // floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
    //ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
    //维护一个k的窗口值
    // 问题：当[-1, Integer.MAX_VALUE]时出现溢出问题，所以要转为Long
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length==0 || k<=0 || t<0) return false;
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i=0; i<nums.length; i++){

            Long floor = treeSet.floor((long)nums[i]);
            Long ceiling = treeSet.ceiling((long)nums[i]);
            if((floor!=null&&nums[i]-floor<=t) || (ceiling!=null&&ceiling-nums[i]<=t)) return true;
            treeSet.add((long)nums[i]);

            if(i>=k) treeSet.remove((long)nums[i-k]);

        }
        return false;
    }

    // bucket法，O(n),O(n)
    public static boolean containsNearbyAlmostDuplicate_x(int[] nums, int k, int t) {
        if(nums==null || nums.length==0 || k<=0 || t<0) return false;
        HashMap<Long, Long> bucket = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            long positiveNum = (long)nums[i] - Integer.MIN_VALUE;
            long pos = positiveNum/((long)t+1); //+1是防止t==0
            if(bucket.containsKey(pos)
                    ||(bucket.containsKey(pos-1)&&positiveNum-bucket.get(pos-1)<=t)
                    || (bucket.containsKey(pos+1)&&bucket.get(pos+1)-positiveNum<=t)) return true;
            if(i>=k){
                long lastBucket = ((long) nums[i-k] - Integer.MIN_VALUE) / ((long)t + 1);
                bucket.remove(lastBucket);
            }
            bucket.put(pos, positiveNum);
        }
        return false;
    }

}

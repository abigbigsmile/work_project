package com.smile.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII_220 {

    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        System.out.println(containsNearbyAlmostDuplicate(nums, 2, 3));;
        System.out.println(containsNearbyAlmostDuplicate_x(nums, 2, 3));;
        System.out.println(containsNearbyAlmostDuplicate_xx(nums, 2, 3));;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1); // why t+1 ? because, if t not plus 1, when t == 0, num divide by 0 will cause crash.

            if (map.containsKey(bucket) // means the key in the map duplicated, it means the must be exist two numbers that the different value between them are less than t
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t) // if the two different numbers are located in two adjacent bucket, the value still might be less than t
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true; // the same reason for -1
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum); //replace the duplicated key
        }
        return false;
    }

    /**
     * 我们可以构建一个大小为t+1的bucket, 比如[0, 1, 2, 3, ... , t] 最大绝对值差的两个数就是t和0.
     * 如果两个数字出现在同一个Bucket内，说明我们已经找到了。 如果不是，则在相邻的两个bucket内再找。
     * 如果相邻的bucket内元素绝对值只差在t以内，说明我们知道到了，返回true.
     * 为了保证j - i <= k，我们在i>=k时，删除 nums[i-k]对应的Bucket.
     * @param nums:数组
     * @param k：两个数下标间隔
     * @param t：两个数差值
     * @return boolean: 找到一组数，nums[i] and nums[j] 他们idx差值在k以内， 即 j - i <= k.
     * 他们的差的绝对值在t以内，即 Math.abs(nums[i] - nums[j]) <= t
     */
    public static boolean containsNearbyAlmostDuplicate_x(int[] nums, int k, int t){
        if(k <1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            long positiveNum = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = positiveNum/((long)t+1); //t+1是因为防止t=0时报错
            if(map.containsKey(bucket)
                || (map.containsKey(bucket-1) && positiveNum-map.get(bucket-1) <= t)
                    || (map.containsKey(bucket+1) && map.get(bucket+1) - positiveNum <= t)) return true;
            if(i >= k){
                long firstBucket = ((long)nums[i-k]-Integer.MIN_VALUE)/((long)t+1);
                map.remove(firstBucket);
            }
            map.put(bucket, positiveNum);
        }
        return false;
    }

    //使用TreeSet
    public static boolean containsNearbyAlmostDuplicate_xx(int[] nums, int k, int t){
        if(nums == null || nums.length ==0 || k < 1 || t < 0) return false;
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            Long floor = treeSet.floor((long)nums[i] + (long)t);
            if(floor != null && floor >= (long)nums[i]-(long)t) return true;
            treeSet.add((long)nums[i]);
            if(i>=k) treeSet.remove((long)nums[i-k]);
        }
        return false;
    }
}

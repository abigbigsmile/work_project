package com.smile.algorithm_review.CollectionUsage;

import java.util.HashSet;

// 查找问题
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {}, nums2 = {1,1};
        int[] res = intersection(nums1, nums2);
        System.out.println();
    }

    //使用了lamba表达式：list转数组；
    //基于hashset的查找属性
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();
        for(int num : nums1) hashSet.add(num);
        for(int num : nums2){
            if(hashSet.contains(num)) temp.add(num);
        }
        int[] res = temp.stream().mapToInt(Integer :: intValue).toArray();
        return res;
    }
}

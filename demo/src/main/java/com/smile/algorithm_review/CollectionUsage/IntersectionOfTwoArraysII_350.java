package com.smile.algorithm_review.CollectionUsage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII_350 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int[] res = intersect_x(nums1, nums2);
        System.out.println();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> resList = new ArrayList<>();

        for(int num : nums1) hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        for(int num : nums2){
            if(hashMap.containsKey(num) && hashMap.get(num)>0){
                hashMap.put(num, hashMap.get(num)-1);
                resList.add(num);
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }


    public static int[] intersect_x(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> resList = new ArrayList<>();
        int i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                resList.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}

package com.smile.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays_xx {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] num = intersection(nums1, nums2);
        for (int i = 0; i < num.length; i++) System.out.print(num[i] + " ");
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("map :" + map.get(20));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums1) {
//            if(map.containsKey(key))map.put(key, map.get(key)+1);
//            else map.put(key, 1);
            //优化上面两句
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        for (int key : nums2) {
           if(map.containsKey(key)&&map.get(key)>0){
               list.add(key);
               map.put(key, map.get(key)-1);
           }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}

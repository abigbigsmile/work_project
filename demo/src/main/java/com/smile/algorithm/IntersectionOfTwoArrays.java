package com.smile.algorithm;

import java.util.*;
import java.util.stream.Collectors;

//349. Intersection of Two Arrays
//两个集合的共同元素
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int[] num = intersection(nums1, nums2);
        for(int i=0; i<num.length; i++) System.out.print(num[i]+ " ");
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        char[] c = {'a', 'b', 'c'};
        List list1 = Arrays.stream( nums1 ).boxed().collect(Collectors.toList());//学会使用这个
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< nums2.length; i++){
            if(list1.contains(nums2[i]))set.add(nums2[i]);
        }
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }
}

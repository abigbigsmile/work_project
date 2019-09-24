package com.smile.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII_219 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums, 2));
        System.out.println(containsNearbyDuplicate_x(nums, 2));

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0, right = left + k;
        if(right > nums.length - 1) right = nums.length-1;
        Set<Integer> set = new HashSet<>();
        while(left < right){
            for(int i=left; i<=right; i++) if(!set.add(nums[i]))return true;
            if(right+1 < nums.length)right++;
            left++;
            set.clear();
        }
        return false;
    }

    public static boolean containsNearbyDuplicate_x(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(i>k)set.remove(nums[i-k-1]);
            if(!set.add(nums[i]))return true;
        }
        return false;
    }
}

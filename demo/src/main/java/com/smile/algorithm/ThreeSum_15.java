package com.smile.algorithm;

import java.util.*;

public class ThreeSum_15 {

    public static void main(String[] args) {
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> lists = threeSum(nums);
        List<List<Integer>> lists_x = threeSum_x(nums);
        List<List<Integer>> lists_xx = threeSum_xx(nums);
        System.out.println();
    }

    //自己写的，还存在问题
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList();
        Set<Integer> set = new HashSet<>();
        if(nums.length < 3) return lists;
        for(int i=0; i<nums.length; i++){
            set.clear();
            for(int j=i+1; j<nums.length; j++){
                if(set.contains(0 - nums[i] - nums[j])){
                    boolean flag = true;
                    for(List list : lists){
                        if(list.contains(nums[i]) && list.contains(nums[j]) && list.contains(0 - nums[i] - nums[j])) {
                            flag = false;
                            if(nums[i] == 0 && nums[j] == 0) flag = true;
                        }
                    }
                    if(flag) lists.add(Arrays.asList(nums[i], nums[j], 0 - nums[i] - nums[j]));
                }else{
                    set.add(nums[j]);
                }
            }
        }
        return lists;
    }

    public static List<List<Integer>> threeSum_x(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        // improve: skip duplicates
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        lo++;
                    } else {
                        // improve: skip duplicates
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    //仿上面
    public static List<List<Integer>> threeSum_xx(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length < 3) return lists;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int left = i+1, right = nums.length-1, sum = 0-nums[i];
            while(left < right){
                if(nums[left] + nums[right] == sum){
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //这里优化，重复的移除
                    while(left < right && nums[left+1] == nums[left]) left++;
                    left++;
                    while(left < right && nums[right-1] == nums[right]) right--;
                    right--;
                }else if(nums[left] + nums[right] > sum){
                    while(left < right && nums[right-1] == nums[right]) right--;
                    right--;
                }else{
                    while(left < right && nums[left+1] == nums[left]) left++;
                    left++;
                }
            }
        }
        return lists;
    }
}

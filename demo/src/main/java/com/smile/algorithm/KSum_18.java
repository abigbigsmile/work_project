package com.smile.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum_18 {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        List<List<Integer>> lists_x = fourSum_x(nums, target);
        System.out.println("end");
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return ksum(nums, 0, 4, target);
    }

    //递归方法：用于计算k个和
    public static List<List<Integer>> ksum(int[] nums, int start, int k, int target){
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length < k) return lists;
        if(k == 2){
            int left=start, right=nums.length-1;
            while(left < right){
                if(nums[left] + nums[right] == target){
                    /**
                     * lists.add(Arrays.asList(nums[left], nums[right]));
                     * 上面生成的list在调用add，remove等方法时会抛java.lang.UnsupportedOperationException异常
                     * https://blog.csdn.net/lin451791119/article/details/82705557
                     */
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    while(left < right && nums[right-1] == nums[right]) right--;
                    while(left < right && nums[left+1] == nums[left]) left++;
                    left ++;
                    right --;
                }else if(nums[left] + nums[right] > target){
                    right --;
                }else{
                    left ++;
                }
            }
        }else{
            for(int i=start; i < nums.length-k+1; i++){
                List<List<Integer>> temp = ksum(nums, i+1, k-1, target-nums[i]);
                if(temp != null){
                    for(List<Integer> list : temp){
                        list.add(0, nums[i]);
                    }
                    lists.addAll(temp);
                }
                while(i+1<nums.length && nums[i+1] == nums[i])i++; //去除重复值
            }
        }
        return lists;
    }

    public static List<List<Integer>> fourSum_x(int[] nums, int target){
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length < 4) return lists;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target)break;
            if(nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]+nums[nums.length-4] < target)continue;
            if(i > 0 && nums[i-1] == nums[i]) continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)break; //second candidate too large
                if(nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target)continue; //second candidate too small
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1, right = nums.length-1;
                while(left < right){
                    if(nums[left] + nums[right] + nums[i] + nums[j] == target){
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left+1] == nums[left]) left++;
                        while(left < right && nums[right-1] == nums[right]) right--;
                        right --;
                        left ++;
                    }else if(nums[left] + nums[right] + nums[i] + nums[j]  > target){
                        right --;
                    }else{
                        left ++;
                    }
                }
            }
        }
        return lists;
    }
}

package com.smile.nowcoder.First;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FindNumbersWithSum {

    /*
    输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for(int num : array) set.add(num);
        for(int num : array){
            if(set.contains(sum-num)){
                if(num*(sum-num) < min) {
                    res.add(num);
                    res.add(sum-num);
                    min = num*(sum-num);
                }
            }
        }
        return res;
    }

    public ArrayList<Integer> FindNumbersWithSum_x(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = array.length-1;
        while(left<right){
            int curSum = array[left] + array[right];
            if(curSum==sum){
                res.add(array[left]);
                res.add(array[right]);
                return res;
            }else if(curSum < sum){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}

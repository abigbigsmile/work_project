package com.smile.nowcoder.second;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 18:06
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FortyTwo {

    //使用hashset
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
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


    //双指针法
    public ArrayList<Integer> FindNumbersWithSum_x(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList();
        if(array==null || array.length<2) return res;
        int left = 0, right = array.length-1;
        while(left<right){
            if(array[left] + array[right] == sum){
                res.add(array[left]);
                res.add(array[right]);
                return res;
            }else if(array[left] + array[right] < sum){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }




}

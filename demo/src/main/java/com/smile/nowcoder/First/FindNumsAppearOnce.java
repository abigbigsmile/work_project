package com.smile.nowcoder.First;

import java.util.HashSet;
import java.util.Iterator;

public class FindNumsAppearOnce {

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 3, 2, 6, 7, 7};
//        FindNumsAppearOnce(arr, new int[1], new int[1]);
        FindNumsAppearOnce_x(arr, new int[1], new int[1]);


    }


    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : array) {
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }
        Iterator<Integer> it = set.iterator();
        num1[0] = it.next();
        num2[0] = it.next();
    }

    public static void FindNumsAppearOnce_x(int [] array,int num1[] , int num2[]) {
        int bitResult = 0;
        // 找出两个只出现一次的数字的异或结果
        for(int num : array) bitResult ^= num;
        // 获得异或结果最右边的一个1（好神奇）
        int bitOne = bitResult - (bitResult&(bitResult-1));
        // 分组转化为求一个数组只存在一个只出现一次的数字那道题
        for(int num : array){
            if((bitOne&num)==bitOne) num1[0] ^= num;
            else num2[0] ^= num;
        }
    }

}

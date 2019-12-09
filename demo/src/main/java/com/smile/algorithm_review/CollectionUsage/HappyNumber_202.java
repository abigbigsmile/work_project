package com.smile.algorithm_review.CollectionUsage;

import java.util.HashSet;

/**
 * 查找问题
 */
public class HappyNumber_202 {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(isHappy(n));
    }

    //当每位平方和为1时返回true；当平方和有重复时表示陷入循环，返回false
    public static boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while(true){
            n = helper(n);
            if(n==1) return true;
            if(!hashSet.add(n))break;
        }
        return false;
    }

    public static int helper(int n){
        int res = 0;
        while(n>0){
            int value = n%10;
            res += value*value;
            n /= 10;
        }
        return res;
    }


}

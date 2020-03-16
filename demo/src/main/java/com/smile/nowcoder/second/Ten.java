package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 0:44
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class Ten {

    public static void main(String[] args) {
        System.out.println(RectCover(0));
        System.out.println(RectCover(1));
        System.out.println(RectCover(2));
        System.out.println(RectCover(3));
        System.out.println(RectCover(4));
        System.out.println(RectCover(5));
    }

    public static int RectCover(int target) {
        if(target==0) return 0;
        if(target==1 || target==2) return target;
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=target; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[target];
    }



}

package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 0:29
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 */
public class Nine {

    public int JumpFloorII(int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=target; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }


}

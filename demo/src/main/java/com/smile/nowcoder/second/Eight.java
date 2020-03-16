package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 0:22
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Eight {

    /**
     * 本质还是动态规划（费波纳茨数列）
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=target; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[target];
    }


}

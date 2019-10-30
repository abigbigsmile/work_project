package com.smile.algorithm;

import java.util.Arrays;

public class Knapsack01 {

    public static void main(String[] args) {
        int[] w = {2, 3, 4};
        int[] v = {3, 5, 7};
        int maxNum = 3, maxWeight = 5;
        int[][] memo =  new int[maxNum+1][maxWeight+1];
        for(int i=0; i<maxNum; i++) Arrays.fill(memo[i], -1);

        System.out.println(bestValue(w, v, memo,maxNum-1, maxWeight));
    }


    // 表示[0, index]个物品在限制重量为maxWeight的情况下的最大价值
    //状态转移方程 res = max(bestValue(w, v, index-1, maxWeight),
    // 相应优化：递归 + 记忆化搜索
    public static int bestValue(int[] w, int[] v, int[][] memo, int index, int maxWeight) {
        if(index < 0 || maxWeight <= 0) return 0;
        if(memo[index][maxWeight] != -1) return memo[index][maxWeight];
        int res = bestValue(w, v, memo, index-1, maxWeight);
        if(maxWeight>=w[index]){
            res = Math.max(res, v[index] + bestValue(w, v, memo, index-1, maxWeight-w[index]));
        }
        memo[index][maxWeight] = res;
        return res;
    }
}

package com.smile.algorithm;

import java.util.Arrays;

public class Knapsack01 {

    public static void main(String[] args) {
        /*int[] w = {2, 3, 4};
        int[] v = {3, 5, 7};
        int maxNum = 3, maxWeight = 5;
        int[][] memo =  new int[maxNum+1][maxWeight+1];
        for(int i=0; i<maxNum; i++) Arrays.fill(memo[i], -1);

        System.out.println(bestValue(w, v, memo,maxNum-1, maxWeight));*/
        int[] w = { 0 , 2 , 3 , 4 , 5 };			//商品的体积2、3、4、5
        int[] v = { 0 , 3 , 4 , 5 , 6 };			//商品的价值3、4、5、6
        int maxWeight = 8;
        System.out.println(bestValue_x(w, v, maxWeight));
        System.out.println(bestValue_xx(w, v, maxWeight));
        System.out.println(bestValue_xxx(w, v, maxWeight));
    }


    /**
     * 表示[0, index]个物品在限制重量为maxWeight的情况下的最大价值
     * 状态转移方程 res = max(bestValue(w, v, index-1, maxWeight),
     * 相应优化：递归 + 记忆化搜索
     * @param w
     * @param v
     * @param memo
     * @param index
     * @param maxWeight
     * @return
     */
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

    /**
     * 01背包问题标准模板
     * 自顶向下的动态规划算法
     * 时间复杂度：O(v.length * maxWeight)
     * 空间复杂度：O(v.length * maxWeight)
      */
    public static int bestValue_x(int[] w, int[] v, int maxWeight) {
        int[][] dp = new int[v.length][maxWeight+1];
        for(int j=0; j<=maxWeight; j++) dp[0][j] = j>=w[0]? v[0] : 0;

        for(int i=1; i<v.length; i++) {
            for(int j=maxWeight; j>=w[i]; j--) {
                dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i-1][j-w[i]]);
            }
        }
        return dp[v.length-1][maxWeight];
    }

    /**
     * 空间优化：dp数组中一行的数据只依赖于上一行的数据，则只需要两行就可以了
     * 空间复杂度：O(2 * maxWeight)
     */
    public static int bestValue_xx(int[] w, int[] v, int maxWeight) {
        int[][] dp = new int[2][maxWeight+1];
        for(int j=0; j<=maxWeight; j++) dp[0][j] = j>=w[0]? v[0] : 0;
        for(int i=1; i<v.length; i++) {
            for(int j=0; j<=maxWeight; j++) {
                if(j >= w[i-1]) dp[i%2][j] = Math.max(dp[(i-1)%2][j], v[i-1] + dp[(i-1)%2][j-w[i-1]]);
                else dp[i%2][j] = dp[(i-1)%2][j];
            }
        }
        return dp[(v.length-1)%2][maxWeight];
    }

    /**
     * 空间优化2：使用单行数组
     */
    public static int bestValue_xxx(int[] w, int[] v, int maxWeight) {
        int[] dp = new int[maxWeight+1];
        for(int j=0; j<=maxWeight; j++) dp[j] = j>=w[0]? v[0] : 0;

        //这个是错误的，在往后遍历的时候，前面的值已经被修改过了
        /*for(int i=1; i<v.length; i++){
            for(int j=0; j<=maxWeight; j++){
                if(j >= w[i]) dp[j] = Math.max(dp[j], v[i]+dp[j-w[i]]);
            }
        }*/

        // 优化
        for(int i=1; i<v.length; i++){
            for(int j=maxWeight; j>=w[i]; j--){
                dp[j] = Math.max(dp[j], v[i]+dp[j-w[i]]);
            }
        }

        return dp[maxWeight];
    }
}

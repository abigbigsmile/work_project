package com.smile.algorithm_review.DynamicProgramming;

public class Knapsack01 {

    public static void main(String[] args) {
        int[] w = {2, 3, 4};
        int[] v = {3, 5, 7};
        int maxWeight = 5;

        /*int[] w = { 0 , 2 , 3 , 4 , 5 };			//商品的体积2、3、4、5
        int[] v = { 0 , 3 , 4 , 5 , 6 };			//商品的价值3、4、5、6
        int maxWeight = 8;*/
        System.out.println(bestValue(w, v, maxWeight));
        System.out.println(bestValue_x(w, v, maxWeight));
        System.out.println(bestValue_xx(w, v, maxWeight));
    }

    /*
        二维数组实现：dp[i][j]表示[0,i]间物品放入容量为j的背包的最大价值
        则 dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]); 第i间物品不放入背包 或 放入背包

        注意：第i件物品的状态，只与第i-1件物品的状态有关，所以可以通过边界dp[0][v]=0(0<=v<=V)，递推得到整个数组（所以要初始化i==0的情况）
        https://juejin.im/post/5b40c99ee51d45190b615f33
     */
    public static int bestValue(int[] w, int[] v, int maxWeight){
        int[][] dp = new int[v.length][maxWeight+1];
        for(int i=0; i<=maxWeight; i++) if(i>=w[0]) dp[0][i] = v[0]; //初始化：用于递推后面的结果

        for(int i=1; i<v.length; i++){
            for(int j=0; j<=maxWeight; j++){
                if(j < w[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
            }
        }

        return dp[v.length-1][maxWeight];
    }


    public static int bestValue_x(int[] w, int[] v, int maxWeight){
        int[][] dp = new int[v.length][maxWeight+1];
        //统一初始化
        for(int i=0; i<v.length; i++){
            for(int j=0; j<=maxWeight; j++){
                if(i==0) dp[i][j] = j>=w[i]? v[i]:0;
                else {
                    dp[i][j] = dp[i-1][j];
                    if(j>=w[i]) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
                }
            }
        }
        return dp[v.length-1][maxWeight];
    }


    // 优化空间复杂度
    public static int bestValue_xx(int[] w, int[] v, int maxWeight) {
        int[] dp = new int[maxWeight+1];
        for(int i=0; i<=maxWeight; i++) if(i>=w[0]) dp[i] = v[0]; //初始化：用于递推后面的结果

        /*
            这个是错误的，在往后遍历的时候，前面的值已经被修改过了:因为没修改前保存的是上一行的数据（保存上一行状态）
            for(int i=1; i<v.length; i++){
                for(int j=0; j<=maxWeight; j++){
                    if(j >= w[i]) dp[j] = Math.max(dp[j], v[i]+dp[j-w[i]]);
            }
        }*/

        for(int i=1; i<v.length; i++){
            for(int j=maxWeight; j>=w[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
            }
        }
        return dp[maxWeight];
    }
}

package com.smile.algorithm_review.DynamicProgramming;

public class BestTimeToBuyAdSellStock_121 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        for(int i=1; i<prices.length; i++){
            buy = Math.max(buy, -prices[i]); // 当天买 或 之前买
            sell = Math.max(sell, buy+prices[i]); //当天卖 或 之前卖
        }
        return sell;
    }
}

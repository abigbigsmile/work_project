package com.smile.algorithm;

//DP问题：又是一题分为多个状态的DP问题
public class WiggleSubsequence_376 {
    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));
    }

    //两个状态：up[i]表示在[0,i]中，到i位置时首差值为正的摆动子序列的最大长度
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length==0) return 0;
        int[] up = new int[nums.length];
        int[] down =new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                up[i] = down[i-1]+1;
                down[i] = down[i-1];
            }else if(nums[i] < nums[i-1]){
                up[i] = up[i-1];
                down[i] = up[i-1]+1;
            }else{
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[nums.length-1], down[nums.length-1]);

    }


    public static int wiggleMaxLength_x(int[] nums) {
        if (nums.length == 0) return 0;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) down = up + 1;
            else if (nums[i] > nums[i - 1]) up = down + 1;
        }
        return Math.max(up, down);
    }
}

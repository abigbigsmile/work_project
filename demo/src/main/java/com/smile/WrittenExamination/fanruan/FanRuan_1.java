package com.smile.WrittenExamination.fanruan;

public class FanRuan_1 {

    /**
     * 题目：给定数组,任意相邻两个元素的差的绝对值等于1,设计算法,在该数组中如果该元素的值多次出现,返回第一次的位置
     *
     * 思路：
     * 例如:{4,5,6,5,6,7,8,9,10,9},元素9出现了2次,第一次出现的位置是7;
     *
     * 遇到算法,首先分析一下,举一两个例子,看看规律
     *
     * 思路:假如查找的是9,即t=9,从第一个数组开始,A[0]=4,那么t-A[0]=5,第二步再计算t-A[5]=2,此时5+2=7;A[7]就是目标数9了;
     *
     * 因此这种方法就是从A[0]开始,逐步根据目标值与A[t]的差来决定的,不断更新t的值,直到找到值或者索引越界为止;
     *
     * 这种算法主要利用了当前位置的数与查找数的差来实现跨越式搜索。算法效率要比遍历数组的算法要高一些，并且易于实现。
     */

    public static void main(String[] args) {
        int[] A = { 4, 5, 6, 5, 6, 7, 8, 9, 10, 9 };
        int[] B = { 12, 11, 12, 10, 11, 10, 9, 8, 9, 8 };
        int res1 = getFirstIndex(A, 6);
        int res2 = getFirstIndex(B, 3);
        System.out.println();
    }

    public static int getFirstIndex(int[] nums, int target){
        int index = 0;
        while(index<nums.length){
            if(nums[index] == target) return index;
            else index += Math.abs(target-nums[index]);
        }
        return -1;
    }


}

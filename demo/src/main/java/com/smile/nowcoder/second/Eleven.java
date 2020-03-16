package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 0:48
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Eleven {

    /**
     * 使用函数
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        String binaryStr = Integer.toBinaryString(n);
        int res = 0;
        for(int i=0; i<binaryStr.length(); i++){
            if(binaryStr.charAt(i)=='1') res++;
        }
        return res;
    }

    /**
     * 与运算
     * @param n
     * @return
     */
    public int NumberOf1_x(int n) {
        int count = 0;
        while(n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }






}

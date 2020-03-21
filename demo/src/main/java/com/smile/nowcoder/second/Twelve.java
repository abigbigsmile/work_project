package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 10:16
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */
public class Twelve {

    // 快速幂：举例:10^1101 = 10^0001*10^0100*10^1000， 即2^6 = 2^3 * 2^3
    public static double Power_x(double base, int exponent) {
        double res = 1.0;
        double cur = base; //保存当前值
        int e;
        if(exponent>0) e = exponent;
        else if(exponent==0) return 1;
        else {
            if(Math.abs(base)<=1e-15) throw new RuntimeException("分母不能为0");//判断0
            e = -exponent;
        }
        // 遍历完所有的1
        while(e!=0){
            if((e&1)==1) res *= cur;
            e >>= 1; //右移一位
            cur *= cur; //cur翻倍
        }
        return exponent>0? res : 1/res;
    }

}

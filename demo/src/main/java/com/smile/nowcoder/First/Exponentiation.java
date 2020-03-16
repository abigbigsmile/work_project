package com.smile.nowcoder.First;

public class Exponentiation {

    public static void main(String[] args) {
        double base = 2.3;
        int exponent = 5;
        System.out.println(Power(base,exponent));
        System.out.println(Power_x(base,exponent));
    }


    public static double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    // 快速幂：举例:10^1101 = 10^0001*10^0100*10^1000， 即2^6 = 2^3 * 2^3
    public static double Power_x(double base, int exponent) {
        double res = 1.0;
        double cur = base; //保存当前值
        int e;
        if(exponent>0) e = exponent;
        else if(exponent==0) return 1;
        else {
            if(base==0) throw new RuntimeException("分母不能为0");
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

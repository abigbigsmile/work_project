package com.smile.nowcoder.second;

import java.util.Arrays;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/20 14:04
 * @ModifiedBy smile
 */


/**
 * 题目描述: 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
public class FifthtyOne {

    //双重循环：时间复杂度为O(n^2)
    public int[] multiply(int[] A) {
        if(A==null) return null;
        int[] B = new int[A.length];
        Arrays.fill(B, 1);
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A.length; j++){
                if(i==j)continue;
                else B[i] *= A[j];
            }
        }
        return B;
    }


    //将双重循环拆分成两个循环
    public int[] multiply_x(int[] A) {
        if(A==null) return null;
        int[] B = new int[A.length];

        //计算下三角
        B[0] = 1;
        for(int i=1; i<A.length; i++){
            B[i] = B[i-1] * A[i-1];
        }

        //计算上三角
        int temp = 1;
        for(int i=A.length-2; i>=0; i--){
            temp = temp * A[i+1];
            B[i] = B[i]*temp;
        }

        return B;

    }



}

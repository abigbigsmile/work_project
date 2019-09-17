package com.smile.algorithm;

import java.util.HashMap;
import java.util.Map;

public class FourSumII_454 {

    public static void main(String[] args) {

    }

    //使用hashmap存储D数组元素，时间复杂度减为O(n^3)
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<D.length; i++){
            map.put(D[i], map.getOrDefault(D[i], 0) + 1);
        }

        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                for(int k=0; k<C.length; k++){
                    if(map.containsKey(0-A[i]-B[j]-C[k]))count += map.get(0-A[i]-B[j]-C[k]);
                }
            }
        }
        return count;
    }

    //使用hashmap存储C+D数组元素，时间复杂度减为O(n^2)
    public static int fourSumCount_x(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<C.length; i++){
            for(int j=0; j<D.length; j++){
                map.put(C[i]+D[j], map.getOrDefault(C[i]+D[j], 0)+1);
            }
        }

        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                if(map.containsKey(0-A[i]-B[j]))count += map.get(0-A[i]-B[j]);
            }
        }
        return count;
    }

    public static int fourSumCount_xx(int[] A, int[] B, int[] C, int[] D){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int a : A)
            for(int b : B){
                int s = a+b;
                map.put( s, map.getOrDefault(s, 0)+1 );
            }
        int result=0;
        for(int c : C)
            for(int d : D){
                int s = -c-d;
                result += map.getOrDefault(s, 0); //这一条语句是关键
            }
        return result;
    }

}

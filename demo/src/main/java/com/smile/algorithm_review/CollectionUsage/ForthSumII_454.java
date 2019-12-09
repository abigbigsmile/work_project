package com.smile.algorithm_review.CollectionUsage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 数组问题
 */
public class ForthSumII_454 {

    public static void main(String[] args) {
        int[] A = { 1, 2}, B = {-2,-1}, C = {-1, 2}, D = { 0, 2};
        System.out.println(fourSumCount(A, B, C, D));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                int sum = A[i]+B[j];
                map1.put(sum, map1.getOrDefault(sum, 0)+1);
            }
        }

        for(int i=0; i<C.length; i++){
            for(int j=0; j<D.length; j++){
                int sum = C[i]+D[j];
                map2.put(sum, map2.getOrDefault(sum, 0)+1);
            }
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> entry : map2.entrySet()){
            if(map1.containsKey(-entry.getKey())) res += map1.get(-entry.getKey())*entry.getValue();
        }

        return res;
    }
}

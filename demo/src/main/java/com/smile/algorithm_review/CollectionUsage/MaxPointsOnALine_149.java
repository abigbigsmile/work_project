package com.smile.algorithm_review.CollectionUsage;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxPointsOnALine_149 {

    public static void main(String[] args) {
//        int[][] points = {{1,1},{2,2},{3,3}};
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        if(points.length==0) return 0;
        if(points.length==1) return 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        int res = 0;
        for(int i=0; i<points.length-1; i++){
            int same = 1;//处理两个点重合的情况,但是要加上自己
            int lineMax = 0;
            for(int j=i+1; j<points.length; j++){
                int numerator = points[j][1]-points[i][1];
                int denominator = points[j][0]-points[i][0];

                if(numerator==0 && denominator==0){
                    same++;
                    continue;
                }

                int temp = helper(numerator, denominator);
                String key = numerator/temp + "/" + denominator/temp;
                hashMap.put(key, hashMap.getOrDefault(key, 0)+1);
                lineMax = Math.max(lineMax, hashMap.get(key));
            }
            res = Math.max(res, lineMax+same);
            hashMap.clear();
        }
        return res;
    }

    // 最大公因数：辗转相除法
    public static int helper(int x, int y){
        return y==0? x : helper(y, x%y);
    }
}

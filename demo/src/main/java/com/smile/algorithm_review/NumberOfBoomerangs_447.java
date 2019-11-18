package com.smile.algorithm_review;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs_447 {

    public static void main(String[] args) {

    }

    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        Map<Double, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    double d = Math.pow(points[j][0] - points[i][0], 2) + Math.pow(points[j][1] - points[i][1], 2);
                    map.put(d, map.getOrDefault(d, 0)+1);
                }
            }
            for(int c : map.values()){
                if(c >= 2){
                    count += c*(c-1);
                }
            }
            map.clear();
        }
        return count;
    }
}

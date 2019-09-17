package com.smile.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfBoomerangs_447 {

    public static void main(String[] args) {
        int[][] points = {{0,0}, {1,0}, {2,0}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int count = 0;
        Map<Double, List<int[]>> map = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    double d = Math.pow(points[j][0] - points[i][0], 2) + Math.pow(points[j][1] - points[i][1], 2);
                    List list = map.getOrDefault(d, new ArrayList<>());
                    list.add(points[j]);
                    map.put(d, list);
                }
            }
            for(List list : map.values()){
                if(list.size() >= 2){
                    count += list.size()*(list.size()-1);
                }
            }
            map.clear();
        }
        return count;
    }
}

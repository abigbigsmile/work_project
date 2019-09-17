package com.smile.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine_149 {

    public static void main(String[] args) {
        int[][] points = {{1,1},{3,2},{5,3},{1,1},{4,1},{2,3},{1,4}};
        System.out.println(maxPoints(points));
        System.out.println(maxPoints_x(points));
    }

    public static int maxPoints(int[][] points) {
        if(points.length == 0) return 0;
        if(points.length < 2) return 1;
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0; i<points.length-1; i++){
            int lineMax = 0;
            int same = 1; //内循环中计算个数时还没加自己本身
            for(int j=i+1; j<points.length; j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if(x==0 && y==0){
                    same ++;
                    continue;
                }
                int gcd = generateGcd(x, y);
                x /= gcd;
                y /= gcd;
                String grap = String.valueOf(x) + "/" + String.valueOf(y);
                map.put(grap, map.getOrDefault(grap, 0) + 1);
                lineMax = Math.max(lineMax, map.get(grap));
            }
            res = Math.max(res, lineMax+same);
            map.clear();
        }
        return res;
    }

    public static int maxPoints_x(int[][] points) {
        /*
        遍历每个点，看它和后面的每个点构成的直线上有多少个点
        对每个点建立map，斜率是key
        斜率要用分数的形式，不要用double的形式存
        计算分数时先求分子分母的最大公约数gcd，再都除以gcd
        重合的点特殊处理
        */
        int l = points.length;
        if (l == 0) return 0;
        if (l <= 2) return l;
        int res = 0;
        for (int i = 0; i < l - 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int overlap = 0;
            int lineMax = 0;
            for (int j = i + 1; j < l; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGcd(x, y);
                x /= gcd;
                y /= gcd;
                // 用string来存储斜率
                String slope = String.valueOf(x) + String.valueOf(y);
                int count = map.getOrDefault(slope, 0);
                count++;
                map.put(slope, count);
                lineMax = Math.max(lineMax, count);
            }
            res = Math.max(res, lineMax + overlap + 1);
        }
        return res;
    }

    public static int generateGcd(int x, int y) {
        if (y == 0) return x;
        return generateGcd(y, x % y);
    }
}

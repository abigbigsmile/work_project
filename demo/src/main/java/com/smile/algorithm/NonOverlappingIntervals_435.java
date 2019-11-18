package com.smile.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 类似于最长上升子序列问题
 */
public class NonOverlappingIntervals_435 {

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int[] dp = new int[intervals.length];
        //dp[i]表示[0, i]能构成的最长不重叠区间序列个数
        Arrays.fill(dp, 1);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[o1.length-1] - o2[o2.length-1];
                }else{
                    return o1[0] - o2[0];
                }

            }
        });
        for(int i=1; i<intervals.length; i++){
            for(int j=0; j<i; j++){
                //重叠的时候
                if(intervals[i][0] >= intervals[j][1])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int max = 0;
        for(int count : dp) max = Math.max(max, count);
        return intervals.length - max;
    }

    public static int eraseOverlapIntervals_x(int[][] intervals) {
        //贪心算法
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2)  {
                if(o1[1] != o2[1]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });
        int res = 1;
        int pre = 0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= intervals[pre][1]){
                res++;
                pre = i;
            }
        }
        return intervals.length-res;

    }
}

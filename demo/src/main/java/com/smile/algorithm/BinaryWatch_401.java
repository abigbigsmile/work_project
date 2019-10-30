package com.smile.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch_401 {

    public static void main(String[] args) {
        int num = 4;
        List<String> res = readBinaryWatch(num);
        System.out.println();
    }


    public static List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] time = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        backtrack(res, time, 0, 0, num, 0, 0);
        return res;
    }

    public static void backtrack(List<String> res, int[] time, int hour, int minute, int num, int count, int start){
        if(hour>11 || minute>59) return;
        if(count == num){
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":").append(minute>=10? minute : "0"+minute);
            res.add(sb.toString());
        }
        for(int i=start; i<time.length; i++){
            if(i<4) hour+=time[i];
            else minute+=time[i];
            backtrack(res, time, hour, minute, num, count+1, i+1);
            if(i<4) hour-=time[i];
            else minute-=time[i];
        }
    }


}

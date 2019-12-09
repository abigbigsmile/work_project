package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch_401 {

    public static void main(String[] args) {
        int num = 1;
        List<String> res = readBinaryWatch(num);
        System.out.println();
    }


    public static List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] time = {1,2,4,8,1,2,4,8,16,32};
        helper(num, time, 0, 0, 0, res, 0);
        return res;
    }

    public static void helper(int num, int[] time, int start, int hour, int min, List<String> res, int count){
        if(hour>11 || min>59) return;
        if(count==num){
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":").append(min>9? min : "0"+min);
            res.add(sb.toString());
        }else{
            for(int i=start; i<time.length; i++){
                if(i<4) hour += time[i];
                else min += time[i];
                helper(num, time, i+1, hour, min, res, count+1);
                if(i<4) hour -= time[i];
                else min -= time[i];
            }
        }
    }
}

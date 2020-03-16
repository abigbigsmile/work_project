package com.smile.nowcoder.First;

import java.util.ArrayList;

public class FindContinuousSequence {

    public static void main(String[] args) {
        int sum = 100;
        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(sum);
        System.out.println();
    }


    // 双指针
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int start = 1, end = 2;
        while(start<end){
            int curSum = (start+end)*(end-start+1)/2;
            if(curSum==sum){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i=start; i<=end; i++) temp.add(i);
                res.add(temp);
                start++;
            }else if(curSum<sum){
                end++;
            }else{
                start++;
            }
        }
        return res;
    }



}

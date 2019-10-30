package com.smile.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
//        int result = minimumTotal(triangle);
        int result = minimumTotal_x(triangle);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public static int minimumTotal_x(List<List<Integer>> triangle) {
        int len = triangle.get(triangle.size()-1).size();
        int[] dp = new int[len + 1];
        for(int i=triangle.size()-1; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }


}

package com.smile.DynamicProgramming;

import java.util.List;

public class Triangle_120 {



    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()) return 0;
        int[] dp = new int[triangle.size()+1];
        for(int i=triangle.size()-1; i>=0 ; i--){
            for(int k=0; k<triangle.get(i).size(); k++){
                dp[k] = Math.min(dp[k], dp[k+1]) + triangle.get(i).get(k);
            }
        }
        return dp[0];
    }


}

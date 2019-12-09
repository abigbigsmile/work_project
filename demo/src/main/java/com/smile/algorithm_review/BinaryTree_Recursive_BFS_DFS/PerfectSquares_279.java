package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import java.util.HashSet;
import java.util.LinkedList;

public class PerfectSquares_279 {

    public static void main(String[] args) {
        int n = 0;
        System.out.println(numSquares(n));
        System.out.println(numSquares_x(n));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n+2];
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=1; i-j*j>=0; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1) ;
            }
        }
        return dp[n];
    }

    // 会出现Time Limit Exceeded
    public static int numSquares_x(int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.offer(n);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int cur = queue.poll();
                if(cur==0) return count;
                for(int i=1; cur-i*i>=0; i++) queue.offer(cur-i*i);
            }
            count++;
        }
        return count;
    }

    // 优化
    public static int numSquares_xxx(int n) {
        int res = -1;
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(n);
        while(!queue.isEmpty()){
            res ++;
            int size = queue.size();
            while(size-- > 0){
                int cur = queue.poll();
                if(cur == 0) return res;
                for(int i=1; i*i<=cur; i++){
                    if( !visited.contains(cur-i*i)) queue.offer(cur-i*i);
                    visited.add(cur-i*i);
                }
            }
        }
        return res;

    }

}

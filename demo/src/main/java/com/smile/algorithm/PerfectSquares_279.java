package com.smile.algorithm;

import java.util.*;

public class PerfectSquares_279 {
    public static void main(String[] args) {
        System.out.println(numSquares(13));
        System.out.println(numSquares_x(13));
        System.out.println(numSquares_xx(13));
    }

    public static int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            depth++;
            while(size-- > 0) {
                int u = q.poll();
                for(int i = 1; i*i <= n; i++) {
                    int v = u+i*i;
                    if(v == n) {
                        return depth;
                    }
                    if(v > n) {
                        break;
                    }
                    if(!visited.contains(v)) {
                        q.offer(v);
                        visited.add(v);
                    }
                }
            }
        }
        return depth;
    }

    public static int numSquares_x(int n) {
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

    //使用动态规划
    public static int numSquares_xx(int n){
        int[] dp = new int[n+1]; //想好dp[i]代表的意义，表示当n=i时的最小个数
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j*j<=i ; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}

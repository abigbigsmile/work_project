package com.smile.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares_279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
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
}

package com.smile.algorithm_review.DynamicProgramming;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PerfectSquares_279 {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }


    public static int numSquares(int n) {
        LinkedList<Integer> queue = new LinkedList<>(); //queue实现层序遍历树
        Set<Integer> visited = new HashSet<>(); //判断是否已经加入过queue
        queue.offer(n);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int cur = queue.poll();
                if(cur==0) return level;
                for(int i=1; i*i<=cur; i++){
                    if(!visited.contains(cur-i*i)){
                        queue.offer(cur-i*i);
                        visited.add(cur-i*i);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}

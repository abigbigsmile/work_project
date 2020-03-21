package com.smile.nowcoder.second;

import com.smile.nowcoder.First.GetLeastNumbers_Solution;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/18 17:11
 * @ModifiedBy smile
 */
public class TwentyNine {

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8};
        ArrayList<Integer> res = GetLeastNumbers_Solution(input, 4);
    }

    //使用优队列构建最大堆
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input==null || input.length==0 || k > input.length) return res;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b-a);
        for(int num : input){
            priorityQueue.offer(num);
            if(priorityQueue.size()>k) priorityQueue.poll();
        }


        while(!priorityQueue.isEmpty()){
            res.add(priorityQueue.poll());
        }
        return res;
    }

}

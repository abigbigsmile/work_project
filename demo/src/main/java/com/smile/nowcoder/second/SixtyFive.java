package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/21 23:13
 * @ModifiedBy smile
 */

import java.util.*;

/**
 * 题目描述: 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class SixtyFive {

    private static PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue()-a.getValue());

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> res = maxInWindows_x(num, 3);
        System.out.println();
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList();
        if(num==null || num.length==0 || size<=0 || size>num.length) return res;
        int left=0, right=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(left+size-1<num.length){
            if(right-left<size){
                map.put(right, num[right]);
                right++;
            }else{
                for(Map.Entry<Integer, Integer> entry : map.entrySet()) maxHeap.offer(entry);
                res.add(maxHeap.peek().getValue());
                //删除窗口左边的值
                map.clear();
                Iterator<Map.Entry<Integer, Integer>> iterator = maxHeap.iterator();
                while(iterator.hasNext()){
                    if(iterator.next().getKey() == left){
                        iterator.remove();
                        break;
                    }
                }
                left++;

            }
        }
        return res;
    }


    //最多丢弃n次所以，其实是o（n）的做法
    public static ArrayList<Integer> maxInWindows_x(int [] num, int size){
        ArrayList<Integer> res = new ArrayList();
        if(num==null || num.length==0 || size<=0 || size>num.length) return res;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0; i<num.length; i++){
            //队列头存储最大值
            while(!queue.isEmpty() && num[queue.peekLast()] < num[i]) queue.pollLast();
            queue.addLast(i);
            //判断队列头是否过期
            if(queue.peekFirst() + size == i) queue.pollFirst();

            //向result列表中加入元素
            if (i >= size - 1) res.add(num[queue.peekFirst()]);
        }

        return res;
    }

}

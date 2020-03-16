package com.smile.nowcoder.First;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        int k = 0;
//        ArrayList<Integer> res = GetLeastNumbers_Solution(arr, k);
        ArrayList<Integer> res = GetLeastNumbers_Solution_x(arr, k);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input==null || input.length==0 || input.length<k) return res;
        int left=0, right=input.length-1;
        while(left<right){
            int pivot = patition(input, left, right);
            if(pivot==k) break;
            else if(pivot<k) left = pivot+1;
            else right = pivot-1;
        }
        for(int i=0; i<k; i++) res.add(input[i]);
        return res;
    }


    public static int patition(int[] arr, int left, int right){
        if(left>=right) return left;
        int value = arr[left];
        int lt = left, rt = right;
        while(lt<rt){
            while(lt<rt && arr[rt]>value) rt--;
            while(lt<rt && arr[lt]<=value) lt++;
            swap(arr, lt, rt);
        }
        swap(arr, left, lt);
        return lt;
    }


    public static void swap(int[] cs,int i,int j){
        int temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }



    public static ArrayList<Integer> GetLeastNumbers_Solution_x(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input==null || input.length==0 || input.length<k) return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);
        for(int num : input){
            if(maxHeap.size()<k) maxHeap.offer(num);
            else{
                if(!maxHeap.isEmpty() && maxHeap.peek()>num) {
                    maxHeap.poll();
                    maxHeap.offer(num);
                }
            }
        }
        while(!maxHeap.isEmpty()) res.add(maxHeap.poll());
        return res;
    }
}

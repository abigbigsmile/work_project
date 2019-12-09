package com.smile.algorithm_review.CollidingPointer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 双指针问题
 */
public class KthLargestElementInAnArray_215 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
        System.out.println(findKthLargest_x(nums, k));
        System.out.println(findKthLargest_xx(nums, k));


        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        quick(arr, 0, arr.length-1);
        System.out.println();
    }

    //Arrays排序
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //优先队列
    public static int findKthLargest_x(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums) queue.offer(num);
        while(queue.size()>k) queue.poll();
        return queue.peek();
    }

    //利用快速排序实现
    public static int findKthLargest_xx(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        while(left<right){
            int pivot = partition(nums, left, right);
            if(pivot==nums.length-k) return nums[pivot];
            else if(pivot>nums.length-k) right = pivot-1;
            else left = left+1;
        }
        return nums[left];
    }

    //双指针法
    public static int partition(int[] nums, int left, int right){
        if(left >= right) return left;
        int tempIndex = left;
        int key = nums[left];
        while(left < right){
            while(left<right && nums[right]>=key) right--;
            while(left<right && nums[left]<=key)left++;
            if(left<right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        //这一次交换很重要
        int temp = nums[tempIndex];
        nums[tempIndex] = nums[left];
        nums[left] = temp;
        return left;
    }

    public static void quick(int[] arr, int left, int right){
        if(left >= right)return;
        int pivot = partition(arr, left, right);
        quick(arr, 0, pivot-1);
        quick(arr, pivot+1, right);
    }


}

package com.smile.sort;

import static com.smile.sort.Utils.print;
import static com.smile.sort.Utils.swap;

public class Quick {

    //挖坑法
    public static int partition_digging(int[] arr, int left, int right){
        int pivot = arr[left];
        while(left < right){
            while(left < right && pivot <= arr[right])right--;
            if(left < right) arr[left++] = arr[right];
            while(left < right && pivot >= arr[left])left++;
            if(left < right) arr[right--] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    //两指针法
    public static int partition_double_pointer(int[] arr, int left, int right){
        int temp = left;
        int pivot = arr[left];
        while(left < right){
            //这一步很重要:以左边作为基准，则要先从右边开始遍历。为什么？
            //先从左边开始,相遇数是大于基准数的，无法满足temp左边的数都小于它。所以进行扫描，要从基准数的对面开始
            while(left < right && arr[right] >= pivot) right--;
            while(left < right && arr[left] <= pivot) left++;
            swap(arr, left, right);
        }
        //这一步要注意，记得最后调换中间值和初值
        swap(arr, temp, left);
        return left;
    }


    public static void quick(int[] arr, int left, int right){
        if(left >= right)return;
//        int pivot = partition_digging(arr, left, right);
        int pivot = partition_double_pointer(arr, left, right);
        quick(arr, 0, pivot-1);
        quick(arr, pivot+1, right);
    }

    public static void quick_three_way(int[] arr, int left, int right){
        if(left >= right) return;
        int lt = left, gt = right, pos = left+1;
        int key = arr[left];
        while(pos <= gt){
            if(arr[pos] < key) swap(arr, pos++, lt++);
            else if(arr[pos] > key) swap(arr, pos, gt--);
            else pos++;
        }
        //注意这里，上面不能是pos,要是pos-1
        quick_three_way(arr, left, pos-1);
        quick_three_way(arr, pos, right);
    }

    //使用快排找出第k大的值
    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int pivot = partition_double_pointer(nums, left, right);
            if(pivot+k==nums.length) return nums[pivot];
            else if(pivot+k < nums.length) left = pivot+1;
            else right = pivot-1;
        }
        return nums[left];
    }






    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        print(arr);
        //quick(arr, 0, arr.length-1);
        //quick_three_way(arr, 0, arr.length-1);
        int val = findKthLargest(arr, 2);
        System.out.println("val :" + val);
        //print(arr);
    }
}

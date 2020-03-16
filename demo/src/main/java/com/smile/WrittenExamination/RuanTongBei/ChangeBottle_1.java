package com.smile.WrittenExamination.RuanTongBei;

import java.util.Scanner;

/**
 * 有N个瓶子，编号 1 ~ N，放在架子上。
 *
 * 比如有5个瓶子：
 * 2 1 3 5 4
 *
 * 要求每次拿起2个瓶子，交换它们的位置。
 * 经过若干次后，使得瓶子的序号为：
 * 1 2 3 4 5
 *
 * 对于这么简单的情况，显然，至少需要交换2次就可以复位。
 *
 * 如果瓶子更多呢？你可以通过编程来解决。
 */
public class ChangeBottle_1 {

    public static void main(String[] args) {

        int[] nums = {3,1,2,5,4};
        //System.out.println(minimumChange(nums));
        System.out.println(minimumChange_x(nums));
    }

    // 优化的冒泡排序，错误
    public static int minimumChange(int[] nums){
        int res = 0;
        int lastSwap = nums.length-1;
        int start = nums.length-1;
        for(int i=nums.length-1; i>=0; i--){
            for(int j=0; j<start; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                    res++;
                    lastSwap = j;
                }
            }
            start = lastSwap;
        }
        return res;
    }

    public static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static int minimumChange_x(int[] nums){
        int res = 0;
        for(int i=0; i<nums.length;){
            if(nums[i] == i+1) i++;
            else {
                swap(nums, i, nums[i]-1);
                res ++;
            }
        }
        return res;
    }


}

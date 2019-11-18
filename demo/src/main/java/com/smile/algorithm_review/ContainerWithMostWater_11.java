package com.smile.algorithm_review;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {

    }

    //双指针法
    public static int maxArea(int[] height) {
        if(height.length==0) return 0;
        int left=0, right=height.length-1;
        int max = Integer.MIN_VALUE;
        while(left<right){
            max = Math.max(max, (right-left)*Math.min(height[left], height[right]));
            if(height[left]<=height[right]) left++;
            else right--;
        }
        return max;
    }
}

package com.smile.algorithm_review;

public class MoveZeroes_283 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
//        moveZeroes(nums);
        moveZeroes_x(nums);
        System.out.println();
    }

    public static void moveZeroes(int[] nums) {
        if(nums.length==0) return;
        int notZero = 0;
        for(int num : nums) if(num!=0)notZero++;
        int pos = 0;
        for(int i=0; i<nums.length; i++){
            if(pos<=notZero){
                if(nums[i]!=0)nums[pos++] = nums[i];
            }else{
                nums[i]=0;
            }
        }
        while (pos<nums.length) nums[pos++] = 0;
    }

    public static void moveZeroes_x(int[] nums) {
        int n = nums.length;
        int zero=0;
        int temp;
        for(int i=0; i<n; i++){
            if(nums[i]!=0){
                temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                zero ++;
            }
        }

    }
}

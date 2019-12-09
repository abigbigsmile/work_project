package com.smile.algorithm_review;

import java.util.Arrays;
import java.util.HashSet;

// time: O(n) space: O(1)
public class FirstMissingPositive_41 {


    public static void main(String[] args) {
        int[] nums = {-1,4,2,1,9,10};
//        int res = findnum(nums);
//        int res = firstMissingPositive_x(nums);
        int res = firstMissingPositive_xx(nums);

        System.out.println(res);
    }


    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        for(int i=1; i<=nums.length+1; i++) if(!set.contains(i)) return i;
        return -1;
    }


    /*
        1. 统计出数组中的正数个数，k个
        2. 缺失的正整数或者是k+1，或者在1-k之间
        3. 要做的事情就是对于1-k之间的数字，放到它该去的位置，这个过程一定说O(n)内完成的
        4. 1-k之间的数都去了它对应的位置，然后遍历，第一个不应该出现的数字就是，如果0-k-1的数字都符合，那就是k+1
     */

    //int a[]= {1,3,4,5};
    private static int findnum(int a[]) {
        int l=0;//l表示已经从1到L已经出现（左边界），l的初值为0。
        int r=a.length;//如果一个数字过大（不合法）扔掉，用r表示这个右边界，r初始值长度
        while(l<r){
            if(a[l]==l+1){//a[0]=1,0-k内合法的数有多少
                l++;
            }else if(a[l]<=l||a[l]>r||a[l]==a[a[l]-1]){//不合法,
                //a[1]=3 a[a[1]-1]=a[2]
                a[l] = a[--r];//缩短右边界
            }else{//合法但是没有在理想的位置上
                swap(a,l,a[l]-1);//交换新数l和已排好的a[l]-1
            }
        }
        return l+1;//返回a[l]=l+1,0-l为已出现的数，l+1代表未出现的数
    }

    private static void swap(int[] arr, int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }



    public static int firstMissingPositive_xx(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int cur = nums[i];
            while(cur>0 && cur<nums.length && cur!=nums[cur-1]){
                int temp = cur;
                nums[i] = nums[cur-1];
                nums[cur-1] = temp;
                cur = nums[i];
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }

}

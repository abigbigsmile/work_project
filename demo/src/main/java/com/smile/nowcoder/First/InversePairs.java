package com.smile.nowcoder.First;

import java.util.Arrays;

public class InversePairs {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
        System.out.println(InversePairs_x(arr));
    }



    // 使用归并排序：O(nlogn)
    public static int InversePairs_x(int [] array) {
        return countAndSort(array, 0, array.length-1);
    }// O(n^2)
    public static int InversePairs(int [] array) {
        if(array.length<=1) return 0;
        int[] dp = new int[array.length];
        dp[0] = 0;
        dp[1] = array[0]>array[1]? 1 : 0;
        for(int i=2; i<array.length; i++){
            dp[i] = dp[i-1];
            for(int j=0; j<i; j++){
                if(array[j]>array[i]) dp[i]+=1;
            }
        }
        return dp[array.length-1]%1000000007;
    }

    public static int countAndSort(int[] arr, int left, int right){
        if(left>=right) return 0;
        int mid = left + (right-left)/2;
        int leftCount = countAndSort(arr, left, mid);
        int rightCount = countAndSort(arr, mid+1, right);
        int count = 0;
        int pre = mid;
        int back = right;

        int[] copy = new int[arr.length];
        int index = right;
        while(pre>=left || back>mid){
            if(pre<left) {
                copy[index--] = arr[back--];
            }else if(back<=mid){
                copy[index--] = arr[pre--];
            }else if(arr[pre]>arr[back]){
                count += back-mid;
                copy[index--] = arr[pre--];
            }else {
                copy[index--] = arr[back--];
            }
        }
        for(int i=left; i<=right; i++) arr[i] = copy[i];
        return (leftCount+rightCount+count)%1000000007;
    }


}

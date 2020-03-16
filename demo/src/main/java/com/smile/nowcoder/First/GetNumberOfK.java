package com.smile.nowcoder.First;

import java.util.Collections;
import java.util.TreeSet;

public class GetNumberOfK {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,10};
        System.out.println(GetNumberOfK(arr, 8));
    }

    public static int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length-1);
        int lastK = getLastK(array, k, 0, length-1);
        if(firstK != -1 && lastK != -1){
            return lastK - firstK + 1;
        }
        return 0;
    }
    //获取第一个k的位置
    private static int getFirstK(int [] array , int k, int left, int right){
        if(left>right) return -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(array[mid] < k){
                left = mid + 1;
            }else if(array[mid] > k){
                right = mid - 1;
            }else if(mid-1>=0 && array[mid-1]==k){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    //获取最后一个k的位置
    private static int getLastK(int [] array , int k, int left, int right){
        if(left>right) return -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(array[mid] < k){
                left = mid + 1;
            }else if(array[mid] > k){
                right = mid - 1;
            }else if(mid+1<=right && array[mid+1]==k){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }


}

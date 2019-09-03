package com.smile.sort;

import java.util.Arrays;

import static com.smile.sort.Utils.print;

public class Merge {

    //递归分割数组，然后合并
    public static void sort(int[] arr, int left, int right){
        if(left >= right)return;
        int middle = left + (right-left)/2;
        sort(arr, left, middle);
        sort(arr,middle+1, right);
        //merge(arr, left, middle, right);
        merge_x(arr, left, middle, right);
    }
    private static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = Arrays.copyOf(arr, arr.length);//不用整个数组进行复制，只复制要排序的left..right

        int l = left, r = middle+1;
        for(int i=left; i<=right; i++){
            if(l > middle) arr[i] = temp[r++];
            else if(r > right) arr[i] = temp[l++];
            else if(temp[l] <= temp[r]) arr[i] = temp[l++];
            else arr[i] = temp[r++];
        }
    }
    //优化上面复制整个数组的情况
    public static void merge_x(int[] arr, int left, int middle, int right){
        int[] temp = new int[right-left+1];
        for(int i=left; i<=right; i++) temp[i-left] = arr[i];

        int l = left, r = middle+1;
        for(int i=left; i<=right; i++){
            if(l > middle) { arr[i] = temp[r-left]; r++;}
            else if(r > right) { arr[i] = temp[l-left]; l++; }
            else if(temp[l-left] <= temp[r-left]) { arr[i] = temp[l-left]; l++; }
            else { arr[i] = temp[r-left]; r++; }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        print(arr);
        sort(arr, 0,arr.length-1);
        print(arr);
    }

}

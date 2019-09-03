package com.smile.sort;

import static com.smile.sort.Utils.print;
import static com.smile.sort.Utils.swap;

//冒泡排序，时间复杂度是O(n^2)
public class Bubble {

    public static void bubbleSort(int[] arr){

        for(int i=arr.length-1; i>=0; i--){
            for(int j=0; j<i; j++){
                if(arr[j] > arr[j+1])swap(arr, j, j+1);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        print(arr);
        bubbleSort(arr);
        print(arr);
    }
}

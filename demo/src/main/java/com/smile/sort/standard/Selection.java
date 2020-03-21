package com.smile.sort.standard;

import static com.smile.sort.standard.Utils.print;
import static com.smile.sort.standard.Utils.swap;

//选择排序法
public class Selection {

    public static void selectionSort(int[] arr){
        int index;
        for(int i=arr.length-1; i>0; i--){
            index = 0;
            for(int j=0; j<=i; j++){
                if(arr[j] > arr[index])index = j;
            }
            swap(arr, i, index);
        }
    }


    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        print(arr);
        selectionSort(arr);
        print(arr);

    }
}

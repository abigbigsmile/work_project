package com.smile.sort.standard;

import static com.smile.sort.standard.Utils.print;
import static com.smile.sort.standard.Utils.swap;

public class Insertion {

    public static void insectionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j]<arr[j-1])swap(arr, j, j-1);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        print(arr);
        insectionSort(arr);
        print(arr);

    }
}

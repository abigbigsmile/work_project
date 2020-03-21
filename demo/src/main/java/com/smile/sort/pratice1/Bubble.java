package com.smile.sort.pratice1;

import com.smile.sort.standard.Utils;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 12:15
 * @ModifiedBy smile
 */
public class Bubble {

    public static void main(String[] args) {
        int[] arr = {364,637,341,406,747,-4, 995,234,971,571,219,930,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        bubbleSort(arr);
        Utils.print(arr);
    }

    public static void bubbleSort(int[] arr){
        if(arr == null) return;
        for(int i=arr.length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}

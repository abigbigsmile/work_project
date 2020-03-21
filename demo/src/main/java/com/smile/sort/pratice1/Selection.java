package com.smile.sort.pratice1;

import com.smile.sort.standard.Utils;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 12:20
 * @ModifiedBy smile
 */
public class Selection {

    public static void main(String[] args) {
        int[] arr = {364,637,341,406,747,-4, 995,234,971,571,219,930,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        selectSort(arr);
        Utils.print(arr);
    }

    public static void selectSort(int[] arr){
        if(arr == null) return;
        for(int i=arr.length-1; i>0; i--){
            int maxIndex = i;
            for(int j=0; j<=i; j++){
                if(arr[j]>arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

}

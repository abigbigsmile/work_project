package com.smile.sort;

import static com.smile.sort.Utils.print;
import static com.smile.sort.Utils.swap;

//冒泡排序，时间复杂度是O(n^2)
public class Bubble {


    public static void bubbleSort(int[] arr){

        for(int i=arr.length-1; i>0; i--){
            for(int j=1; j<=i; j++){
                if(arr[j] < arr[j-1])swap(arr, j, j-1);
            }
        }

    }

    //如果内循环一趟没有进行交换，则表示数组已经有序，则跳出
    public static void bubbleSort_x(int[] arr){
        boolean sorted = false;
        for(int i=arr.length-1; i>0 && !sorted; i--){
            sorted = true;
            for(int j=1; j<=i; j++){
                if(arr[j-1] > arr[j]){
                    swap(arr, j, j-1);
                    sorted = false;
                }
            }
        }
    }

    //记住原来最后一次进行循环
    public static void bubbleSort_xx(int[] arr){
        int lastSwap = arr.length-1;
        int unordered = arr.length-1;
        for(int i=arr.length-1; i>0; i--){
            for(int j=1; j<=unordered; j++){
                if(arr[j-1] > arr[j]){
                    swap(arr, j-1, j);
                    lastSwap = j-1;
                }
            }
            unordered = lastSwap;
        }

    }

    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        print(arr);
//        bubbleSort(arr);
//        bubbleSort_x(arr);
        bubbleSort_xx(arr);
        print(arr);
    }
}

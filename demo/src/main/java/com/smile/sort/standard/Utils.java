package com.smile.sort.standard;

public class Utils {
    public static void print(int[] arr){
        for(int item : arr) System.out.print(item+" ");
        System.out.println();
    }
    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}



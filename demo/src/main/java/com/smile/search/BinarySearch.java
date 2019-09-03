package com.smile.search;

public class BinarySearch {

    //二分查找实现(递归)
    public static int binarySortRecursion(int k, int left, int right, int[] arr){
        if(left > right)return -1;
        int middle = left + (right - left)/2;
        if(k == arr[middle]) return middle;
        else if(k < arr[middle]) return binarySortRecursion(k, left, middle-1, arr);
        else return binarySortRecursion(k, middle+1, right, arr);
    }

    public static int binarySort(int k, int left, int right, int[] arr){
        //定义好边界，在[left, right]范围内查找k
        while(left <= right) { //当left == right时，[left, right]依然有效
            int middle = (left + right) / 2;
            if (k == arr[middle]) return middle;
            else if (k < arr[middle]) right = middle - 1;
            else left = middle + 1;
        }
        return -1;
    }

    public static int[] generateRandomArray(int n, int range){
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = (int)Math.random()*range;
        }
        return arr;
    }

    public static void main(String[] args) {
        //int[] arr = generateRandomArray(10, 100);
        int[] arr = {0,2,7,13,35,57,68,89,92};
        //int index = binarySortRecursion(0,0,arr.length-1,arr);
        int index = binarySort(89,0,arr.length-1,arr);
        System.out.println("index : " + index);

    }

}

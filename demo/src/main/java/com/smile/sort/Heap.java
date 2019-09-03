package com.smile.sort;

import static com.smile.sort.Utils.print;
import static com.smile.sort.Utils.swap;

public class Heap {

    //堆排序
    public static void heapSort(int[] arr){
        //从最后一个非叶子节点开始：最大堆化
        for(int i=arr.length/2-1; i>=0; i--){
            heapify(arr, arr.length, i);
        }

        for(int i=arr.length-1; i>0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    //将数组最大堆化
    public static void heapify(int[] arr, int length, int parent){
        int temp = arr[parent];//先取出当前元素i
        for(int child=parent*2+1;child<length;child=child*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(child+1<length && arr[child]<arr[child+1]){//如果左子结点小于右子结点，k指向右子结点
                child++;
            }
            if(temp > arr[child])break;//堆化从下往上
            arr[parent] = arr[child];
            parent = child;
        }
        arr[parent] = temp;//将temp值放到最终的位置
    }

    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        print(arr);
        heapSort(arr);
        print(arr);
    }
}

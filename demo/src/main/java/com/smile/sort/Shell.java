package com.smile.sort;

import static com.smile.sort.Utils.print;
import static com.smile.sort.Utils.swap;

public class Shell {

    //可更改步长
    public static void shellSort(int[] arr, int step){
        //k表示增量，当增量为1时即表示步长唯一的插入排序
        int k = 1;
        while(k<arr.length/step){
            k = k*step + 1;
        }
        while(k>=1){
            //循环组数对应的次数
            for(int i=k; i<arr.length; i++){
                //对每一个分组进行插入排序
                for(int j=i; j>=k; j-=k){
                    if(arr[j]<arr[j-k])swap(arr,j-k,j);
                }
            }
            //缩小分组增量
            k /= step;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        //int[] arr = {1,7,4,2,6};
        print(arr);
        shellSort(arr, 3);
        print(arr);
    }
}

package com.smile.sort;

import java.util.Arrays;

import static com.smile.sort.Utils.print;

//计数排序法
public class Count {

    //下面的缺点：1、范围固定，应该遍历数组找出范围；2、使用一次循环统计元素在以排序数组中的偏移
    public static void countSort(int[] arr){
        int[] count = new int[100];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        int index = 0;
        for(int i=0; i<count.length; i++){
            for(int j=0; j<count[i]; j++){
                arr[index++] = i;
            }
        }
    }

    //包括负数排序的计数排序法
    public static void countSort_x(int[] arr){
        int min=0, max=0;
        //循环找出范围
        for(int i=0; i<arr.length; i++){
            if(arr[i] < min)min = arr[i];
            if(arr[i] > max)max = arr[i];
        }
        int[] countArray = new int[max - min + 1];
        //以新数组的下标作为数组元素值，值作为元素个数;当存在负数时，注意减去min
        for(int i=0; i<arr.length; i++) countArray[arr[i]-min]++;
        //统计元素在以排序数组中的偏移
        for(int i=1; i<countArray.length; i++)countArray[i] += countArray[i-1];
        //反向遍历数据，根据元素的偏移把元素放置到以排序集合中，并减少一次计数
        int[] temp = new int[arr.length];//临时数组
        for(int i=0; i<arr.length; i++){
            int value = arr[i];
            int position = countArray[value-min] - 1;
            temp[position] = value;
            countArray[value-min] -= 1;
        }
        for(int i=0; i<temp.length; i++)arr[i] = temp[i];

    }


    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        print(arr);
//        countSort(arr);
        countSort_x(arr);
        print(arr);

    }
}

package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 11:25
 * @ModifiedBy smile
 */
public class Thirthteen {

    //插入排序
    public void reOrderArray(int [] array) {
        int k = 0;
        for(int i=0; i<array.length; i++){
            if(array[i]%2==1){
                for(int j=i; j>k; j--){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
                k++;
            }
        }
    }


    // 空间换时间（也可以使用冒泡、插入等排序算法）
    public void reOrderArray_x(int [] array) {
        int left=0, right=array.length-1;
        int l=0, r=array.length-1;
        int[] temp = new int[array.length];
        while(left!=array.length || right!=-1){
            if(array[left]%2!=0) temp[l++] = array[left];
            if(array[right]%2==0) temp[r--] = array[right];
            left++;
            right--;
        }
        for(int i=0; i<temp.length; i++) array[i] = temp[i];
    }





    // 冒泡
    public class Solution {
        public void reOrderArray_xx(int [] array) {
            for(int i= 0;i<array.length-1;i++){
                for(int j=0;j<array.length-1-i;j++){
                    if(array[j]%2==0&&array[j+1]%2==1){
                        int t = array[j];
                        array[j]=array[j+1];
                        array[j+1]=t;
                    }
                }
            }
        }
    }





}

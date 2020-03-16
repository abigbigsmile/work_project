package com.smile.nowcoder.First;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class ChangeOrder {

    public static void main(String[] args) {
        /*int[] array = {1,2,3,4,5,6};
        reOrderArray(array);*/
        Stack stack = new Stack();
        stack.push(1);
        stack.push(1);
    }


    public static void reOrderArray(int [] array) {
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
        //array = Arrays.copyOf(temp, temp.length);
    }
}

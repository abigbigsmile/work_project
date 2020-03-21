package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/18 16:48
 * @ModifiedBy smile
 */


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class TwentyEight {

    // 正常方法
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null || array.length==0) return 0;
        Arrays.sort(array);
        int midValue = array[array.length/2];
        int count = 0;
        for(int num : array) {
            if(num == midValue) count++;
        }
        return count>array.length/2? midValue: 0;
    }

    // 使用IntStream工具
    public int MoreThanHalfNum_Solution_x(int [] array) {
        if(array==null || array.length==0) return 0;
        Arrays.sort(array);
        int midValue = array[array.length/2];
        return IntStream.of(array).filter(num -> num==midValue).count()>array.length/2? midValue:0;

    }

    // 自称牺牲法
    public int MoreThanHalfNum_Solution_xx(int [] array) {
        if(array==null || array.length==0) return 0;
        int preNum = array[0];
        int count = 1;
        for(int i=1; i<array.length; i++){
            if(array[i]==preNum) count++;
            else{
                count--;
                if(count==0){
                    preNum = array[i];
                    count = 1;
                }
            }
        }

        //判断是否超过一半
        int finalPreNum = preNum;
        return IntStream.of(array).filter(num -> num== finalPreNum).count()>array.length/2? preNum:0;
    }

}

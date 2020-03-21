package com.smile.nowcoder.second;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/18 21:30
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class ThirtyTwo {

    public String PrintMinNumber(int [] numbers) {
        if(numbers==null || numbers.length==0) return "";
        String[] strs = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) strs[i] = String.valueOf(numbers[i]);

        Arrays.sort(strs, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String str1 = s1+s2;
                String str2 = s2+s1;
                return str1.compareTo(str2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

}

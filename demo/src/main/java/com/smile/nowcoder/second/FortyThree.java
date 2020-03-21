package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 18:17
 * @ModifiedBy smile
 */

/**
 * 左旋转字符串
 */
public class FortyThree {

    /*
    题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     */
    public String LeftRotateString(String str,int n) {
        if(str==null || str.length()<=1 || n<=0) return str;
        int len = str.length();
        int head = n%len;
        str = str + str;
        return  str.substring(head, head+len);

    }

}

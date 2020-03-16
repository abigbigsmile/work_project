package com.smile.nowcoder.First;

import org.apache.commons.lang.StringUtils;


public class LeftRotateString {

    /*
    汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
    对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     */
    public static void main(String[] args) {
        String str = "helloword";
        int n = 4;
        System.out.println(LeftRotateString(str, n));
        System.out.println(LeftRotateString_x(str, n));

        String s = " ";
        if(str==null || str.isEmpty() || str.length()==0) System.out.println(" 11");
        else System.out.println("33");
    }

    public static String LeftRotateString(String str,int n) {
        if(n%str.length()==0) return str;
        int len = str.length();
        int head = len - n%len + 1;
        String res = str.substring(n%len) + str.substring(0, n%len);
        return res;
    }


    public static String LeftRotateString_x(String str,int n) {
        if(str==null || str.length()==0 || n%str.length()==0) return str;
        int len = str.length();
        n %= len;
        str += str;
        return str.substring(n, len+n);
    }
}

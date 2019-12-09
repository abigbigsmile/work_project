package com.smile.WrittenExamination.fanruan;

public class FanRuan_2 {

    /**
     * 题目：给定两个整数 A 和 B，返回任意字符串 S，要求满足：
     *
     * S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
     * 子串 'aaa' 没有出现在 S 中；
     * 子串 'bbb' 没有出现在 S 中。
     */


    public static void main(String[] args) {
        int A = 4, B = 1;
        System.out.println(strWithout3a3b(A, B));
    }

    public static String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while(A+B>0){
            String temp = sb.toString();
            if(temp.endsWith("aa")){
                sb.append("b");
                B--;
            }else if(temp.endsWith("bb")){
                sb.append("a");
                A--;
            }else if(A>B){
                sb.append("a");
                A--;
            }else{
                sb.append("b");
                B--;
            }
        }
        return sb.toString();
    }


}

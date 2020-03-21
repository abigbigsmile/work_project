package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/20 18:02
 * @ModifiedBy smile
 */



public class FifthtyFive {

    public static void main(String[] args) {

        char[] str = {'+', '.', '3', '4'};
        System.out.println(isNumeric(str));
    }

    // 注意：+-.\都要加\\
    public static boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        return s.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }


    /**
     链接：https://www.nowcoder.com/questionTerminal/6f8c901d091949a5837e24bb82a731f2?answerType=1&f=discussion
     来源：牛客网

     思路：首先要想到所有的情况，然后进行分类讨论。-123.45e-67

     +-号后面必定为数字或后面为.（-.123 = -0.123）
     +-号只出现在第一位或在eE的后一位
     .后面必定为数字或为最后一位（233. = 233.0）
     eE后面必定为数字或+-号
     */
    public boolean isNumeric_x(char[] str) {

        boolean point = false, exp = false; // 标志小数点和指数

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if (i + 1 == str.length || !(str[i + 1] >= '0' && str[i + 1] <= '9' || str[i + 1] == '.')) { // +-号后面必定为数字 或 后面为.（-.123 = -0.123）
                    return false;
                }
                if (!(i == 0 || str[i-1] == 'e' || str[i-1] == 'E')) { // +-号只出现在第一位或eE的后一位
                    return false;
                }


            } else if (str[i] == '.') {
                if (point || exp || !(i + 1 < str.length && str[i + 1] >= '0' && str[i + 1] <= '9')) { // .后面必定为数字 或为最后一位（233. = 233.0）
                    return false;
                }
                point = true;

            } else if (str[i] == 'e' || str[i] == 'E') {
                if (exp || i + 1 == str.length || !(str[i + 1] >= '0' && str[i + 1] <= '9' || str[i + 1] == '+' || str[i + 1] == '-')) { // eE后面必定为数字或+-号
                    return false;
                }
                exp = true;

            } else if (str[i] >= '0' && str[i] <= '9') {


            } else {
                return false;
            }

        }
        return true;
    }

}

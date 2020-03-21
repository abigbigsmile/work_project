package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 23:54
 * @ModifiedBy smile
 */
public class FortySeven {

    /**
     * 题目描述
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * @param n
     * @return
     */

    public int Sum_Solution(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return n+Sum_Solution(n-1);
    }

}

package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 0:41
 * @ModifiedBy smile
 */


/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class ThirtyFour {

    public int FirstNotRepeatingChar(String str) {
        if(str==null) return -1;
        int[] arr = new int[58];//A-Z:65-90; a-z:97-122
        for(char c : str.toCharArray()) arr[c-'A']++;
        for(char c : str.toCharArray()){
            if(arr[c-'A']==1) return str.indexOf(c);
        }
        return -1;
    }

}

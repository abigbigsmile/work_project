package com.smile.nowcoder.second;

import java.util.LinkedList;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/20 19:03
 * @ModifiedBy smile
 */


/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FifthtySix {

    private LinkedList<Character> queue = new LinkedList();
    private int[] crr = new int[256];

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        crr[ch]++;
        if(crr[ch]==1) queue.offer(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while(!queue.isEmpty()){
            if(crr[queue.peek()]==1) return queue.peek();
            else queue.poll();
        }
        return '#';
    }

}

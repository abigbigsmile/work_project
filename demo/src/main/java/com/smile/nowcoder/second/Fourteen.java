package com.smile.nowcoder.second;

import com.smile.algorithm.ListNode;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 13:45
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Fourteen {

    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next = head;
        ListNode front=dummy, back=dummy;
        while(front!=null){
            front = front.next;
            if(k--<=0) back = back.next;
        }
        return back==dummy? null : back;
    }


}

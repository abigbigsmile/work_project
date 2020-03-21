package com.smile.nowcoder.second;

import com.smile.algorithm.ListNode;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 13:48
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Fifthteen {

    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

}

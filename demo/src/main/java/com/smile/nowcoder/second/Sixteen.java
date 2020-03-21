package com.smile.nowcoder.second;

import com.smile.algorithm.ListNode;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 13:53
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Sixteen {

    // 递归
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val<=list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        }else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }


    //正常思路
    public ListNode Merge_x(ListNode list1,ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                dummy.next = list1;
                list1 = list1.next;
            }else{
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = list1==null? list2 : list1;
        return newHead.next;
    }

}

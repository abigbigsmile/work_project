package com.smile.nowcoder.second;

import com.smile.algorithm.ListNode;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/20 19:42
 * @ModifiedBy smile
 */

/**
 * 题目描述: 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class FifthtyEight {

    //递归
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null || pHead.next==null) return pHead;
        if(pHead.val==pHead.next.val){
            while(pHead!=null && pHead.next!=null && pHead.val==pHead.next.val){
                pHead.next = pHead.next.next;
            }
            return deleteDuplication(pHead.next);
        }else{
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    // 非递归
    public ListNode deleteDuplication_x(ListNode pHead){
        if(pHead==null || pHead.next==null) return pHead;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy, back=pHead;
        while(pre!=null && pre.next!=null){
            while(back!=null && back.next!=null && back.val==back.next.val) back = back.next;
            if(pre.next != back){
                pre.next = back.next;
                back = back.next;
            }else{
                back = back.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }


}

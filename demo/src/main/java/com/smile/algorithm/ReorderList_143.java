package com.smile.algorithm;

import com.smile.algorithm.ReverseLinkedListII_92.ListNode;

public class ReorderList_143 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ReverseLinkedListII_92.ListNode head = ReverseLinkedListII_92.createNode(nums);
        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode middle = head, right = head;

        //找到中间指针
        while(right.next != null && right.next.next != null){
            middle = middle.next;
            right = right.next.next;
        }

        ListNode newHead = middle.next;
        middle.next = null;

        //翻转其中一条链表
        ListNode pre = null, temp;
        while(newHead != null){
            temp = newHead.next;
            newHead.next = pre;
            pre = newHead;
            newHead = temp;
        }


        int flag = 0;
        ListNode needle = dummy;

        ListNode p1 = head, p2 = pre;
        //合并两条链表
        while(p1 != null || p2 != null){
            if(flag%2 == 0){
                needle.next = p1;
                p1 = p1.next;
            }else{
                needle.next = p2;
                p2 = p2.next;
            }
            needle = needle.next;
            flag ++;
        }

        head = dummy.next;

    }

}

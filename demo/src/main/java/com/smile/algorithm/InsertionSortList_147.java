package com.smile.algorithm;

import com.smile.algorithm.ReverseLinkedListII_92.ListNode;

public class InsertionSortList_147 {
    public static void main(String[] args) {
        int[] nums = {7,4, 6, 2,1,3};
        ListNode head = ReverseLinkedListII_92.createNode(nums);
        ListNode res = insertionSortList(head);
        //ListNode res = insertionSortList_x(head);
        ReverseLinkedListII_92.printNode(res);
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode begin = dummy, end = head, pos = head.next;
        ListNode p = begin;
        while(pos != null){
            if(p.next != null && p.next.val >= pos.val) p = begin;
            while(p != end){
                if(p.val <= pos.val && p.next != null && p.next.val > pos.val)break;
                p = p.next;
            }
            if(p == end){
                end = end.next;
            }else{
                end.next = pos.next;
                pos.next = p.next;
                p.next = pos;
            }
            pos = end.next;
        }
        return dummy.next;
    }

    public static ListNode insertionSortList_x(ListNode head) {
        if( head == null ){
            return head;
        }
        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            if(pre.next != null && pre.next.val >= cur.val)pre = helper; //优化，不用每次都从头遍历，当pre.next.val >= cur.val才遍历
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            //pre = helper; //优化
            cur = next;
        }
        return helper.next;
    }
}

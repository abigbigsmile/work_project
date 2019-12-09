package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class InsertionSortList_147 {

    public static void main(String[] args) {
        int[] nums = {-1, 5, 3, 4, 0};
        ListNode l1 = ListNode.createNodeList(nums);
        ListNode.printListNode(l1);
        ListNode res = insertionSortList_x(l1);
//        ListNode res = insertionSortList(l1);
        ListNode.printListNode(res);
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode begin=dummy, end=head, cur=head.next;
        while(cur!=null){
            ListNode p = begin;
            while(p!=end){
                if(p.val<=cur.val && p.next!=null && p.next.val>cur.val)break;
                p = p.next;
            }
            if(p==end) end=end.next;
            else{
                end.next = cur.next;
                cur.next = p.next;
                p.next = cur;
            }
            cur = end.next;
        }
        return dummy.next;
    }

    //优化:注意，这个不能初始化dummy.next = head;
    public static ListNode insertionSortList_x(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur=head, p=dummy;
        ListNode temp = null;
        while(cur!=null){
            temp = cur.next;

            if(p.next!=null && p.next.val>cur.val) p = dummy;
            // 在p和p.next之间插入cur
            while(p.next!=null && p.next.val<cur.val) p = p.next;

            cur.next = p.next;
            p.next = cur;
            cur =temp;
        }
        return dummy.next;
    }
}

package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class RemoveDuplicatesFromSortedListII_82 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,3,4,4,5};
        ListNode l1 = ListNode.createNodeList(nums);
        ListNode.printListNode(l1);
//        ListNode res = deleteDuplicates(l1);
        ListNode res = deleteDuplicates_x(l1);
        ListNode.printListNode(res);
    }

    //使用递归，真的很神奇
    //如果值唯一，则按原来的链表顺序，否则，去重再递归
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode next = head.next;
        if(head.val==next.val){
            while(next!=null && head.val==next.val) next=next.next;
            return deleteDuplicates(next);
        }else head.next = deleteDuplicates(head.next);
        return head;
    }

    public static ListNode deleteDuplicates_x(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy, cur=head;
        while(cur.next!=null){
            while (cur.next!=null && cur.val==cur.next.val) cur=cur.next;
            if(pre.next==cur) pre=cur;
            else pre.next=cur.next;
            cur=cur.next;
        }
        return dummy.next;
    }
}

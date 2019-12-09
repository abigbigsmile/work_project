package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class SwapNodesInPairs_24 {

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode l1 = ListNode.createNodeList(nums);
        ListNode.printListNode(l1);
//        ListNode res = swapPairs(l1);
        ListNode res = swapPairs_x(l1);
        ListNode.printListNode(res);
    }

    //凡是可以拆分成子问题的，都是可以考虑使用递归
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode next = head.next;

        next.next = swapPairs(next.next);

        head.next = next.next;
        next.next = head;
        dummy.next = next;

        return dummy.next;
    }

    public static ListNode swapPairs_x(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre=dummy, cur=head;

        while(cur!=null && cur.next!=null){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;

            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }


}

package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class ReverseNodesInKGroup_25 {

    public static void main(String[] args) {
        int[] nums = {1,2};
        ListNode l1 = ListNode.createNodeList(nums);
        ListNode.printListNode(l1);
        ListNode res = reverseKGroup(l1, 2);
        ListNode.printListNode(res);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 0;
        for(ListNode node=head; node!=null; count++, node=node.next);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=0; i+k<=count; i+=k){
            ListNode begin = pre.next, then = begin.next;
            for(int j=1; j<k; j++){
                begin.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = begin.next;
            }
            pre = begin;
        }
        return dummy.next;
    }


}

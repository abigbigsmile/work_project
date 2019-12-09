package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

/**
 * 快慢指针
 */
public class RemoveNthNodeFromEndOfList_19 {

    public static void main(String[] args) {
        int[] nums = {1,4};
        ListNode head = ListNode.createNodeList(nums);
        ListNode.printListNode(head);
        ListNode res = removeNthFromEnd(head, 3);
        ListNode.printListNode(res);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode quick=dummy, slow=dummy;
        while(quick.next!=null){
            quick=quick.next;
            if(n--<=0)slow=slow.next;
        }
        if(n<=0) slow.next = slow.next.next;
        return dummy.next;
    }


}

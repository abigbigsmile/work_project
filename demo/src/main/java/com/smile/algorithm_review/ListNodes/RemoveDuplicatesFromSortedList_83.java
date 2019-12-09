package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class RemoveDuplicatesFromSortedList_83 {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        ListNode head = ListNode.createNodeList(nums);
        ListNode.printListNode(head);
        ListNode res = deleteDuplicates(head);
        ListNode.printListNode(res);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while(p!=null && p.next != null){
            if(p.val == p.next.val) p.next = p.next.next;
            else p = p.next;
        }
        return head;
    }
}

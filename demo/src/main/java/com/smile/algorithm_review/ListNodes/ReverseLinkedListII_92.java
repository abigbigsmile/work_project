package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class ReverseLinkedListII_92 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int m=2, n=5;
        ListNode head = ListNode.createNodeList(nums);
        ListNode.printListNode(head);
        ListNode res = reverseBetween(head, m, n);
        ListNode.printListNode(res);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = temp;
        for(int i=0; i<m-1; i++) pre = pre.next;
        ListNode begin = pre.next, then = begin.next;
        for(int i=0; i<n-m; i++){
            begin.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = begin.next;
        }
        return temp.next;
    }
}

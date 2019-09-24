package com.smile.algorithm;

import com.smile.algorithm.ReverseLinkedListII_92.ListNode;

public class RotateList_61 {

    public static void main(String[] args) {
        int[] nums = {0,1,2};
        ListNode head = ReverseLinkedListII_92.createNode(nums);
        ReverseLinkedListII_92.printNode(reverseKGroup_x(head, 4));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = head, right = head;
        while (right.next != null) {
            if (--k < 0) left = left.next;
            right = right.next;
        }
        dummy.next = left.next;
        left.next = right.next;
        right.next = head;

        return dummy.next;
    }

    public static ListNode reverseKGroup_x(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while(k-- > 0){
            ListNode pre = dummy.next, then = dummy.next;
            while(then.next != null){
                pre = then;
                then = then.next;
            }
            pre.next = then.next;
            then.next = dummy.next;
            dummy.next = then;
        }
        return dummy.next;
    }



}

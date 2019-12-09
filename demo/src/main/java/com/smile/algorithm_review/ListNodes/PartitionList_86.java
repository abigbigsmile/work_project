package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class PartitionList_86 {

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,2};
        ListNode head = ListNode.createNodeList(nums);
        ListNode.printListNode(head);
        ListNode res = partition(head, 3);
        ListNode.printListNode(res);
    }

    public static ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
        ListNode smaller=smallerHead, bigger=biggerHead;
        while(head != null) {
            if(head.val<x){
                smaller.next = head;
                smaller = head;
            }else{
                bigger.next = head;
                bigger = head;
            }
            head = head.next;
        }
        smaller.next = biggerHead.next;
        bigger.next = null;
        biggerHead.next = null;
        return smallerHead.next;
    }
}

package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class ReverseLinkedList_206 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.createNodeList(nums);
        ListNode.printListNode(head);
        ListNode res = reverseList_xxx(head);
        ListNode.printListNode(res);
    }

    //这个需要额外的空间
    public static ListNode reverseList(ListNode head) {
        ListNode newHead=null, p = head;
        while(p!=null){
            ListNode curNode = new ListNode(p.val);
            if(newHead==null){
                newHead = curNode;
            }else{
                curNode.next = newHead;
                newHead = curNode;
            }
            p = p.next;
        }
        return newHead;
    }

    public static ListNode reverseList_x(ListNode head) {
        ListNode newHead=null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public static ListNode reverseList_xx(ListNode head, ListNode newHead) {
        if(head == null)return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseList_xx(next, head);
    }

    // So good.
    public static ListNode reverseList_xxx(ListNode head) {
        // base case
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList_xxx(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

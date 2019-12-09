package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class RemoveLinkedListElements_203 {

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode l1 = ListNode.createNodeList(nums);
        ListNode.printListNode(l1);
//        ListNode res = removeElements(l1, 6);
        ListNode res = removeElements_x(l1, 6);
        ListNode.printListNode(res);
    }

    //非递归
    public static ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre = dummy;
        while(head!=null){
            if(head.val==val) pre.next=head.next;
            else pre=head;
            head=head.next;
        }
        return dummy.next;
    }

    //recursive
    public static ListNode removeElements_x(ListNode head, int val) {
        if(head==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        if(head.val==val) return removeElements_x(head.next, val);
        else head.next = removeElements_x(head.next,val);
        return dummy.next;
    }
}

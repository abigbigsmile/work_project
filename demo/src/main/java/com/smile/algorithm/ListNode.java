package com.smile.algorithm;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }



    public static ListNode createNodeList(int[] nums){
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for(int num : nums){
            p.next = new ListNode(num);
            p = p.next;
        }
        return dummy.next;
    }

    public static void printListNode(ListNode head){
        while(head!=null){
            if(head.next==null)System.out.println(head.val);
            else System.out.print(head.val + "->");
            head = head.next;
        }
    }
}

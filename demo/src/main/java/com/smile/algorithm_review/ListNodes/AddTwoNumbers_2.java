package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {9,9};
        ListNode l1 = ListNode.createNodeList(nums1);
        ListNode l2 = ListNode.createNodeList(nums2);
        ListNode.printListNode(l1);
        ListNode.printListNode(l2);
        ListNode res = addTwoNumbers(l1, l2);
        ListNode.printListNode(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0), p=newHead;
        int toAdd = 0;
        while(l1!=null && l2!=null){
            int value = (l1.val+l2.val+toAdd)%10;
            toAdd = (l1.val+l2.val+toAdd)/10;
            p.next = new ListNode(value);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int value = (toAdd+l1.val)%10;
            toAdd = (toAdd+l1.val)/10;
            p.next = new ListNode(value);
            p = p.next;
            l1 = l1.next;
        }

        while(l2!=null){
            int value = (toAdd+l2.val)%10;
            toAdd = (toAdd+l2.val)/10;
            p.next = new ListNode(value);
            p = p.next;
            l2 = l2.next;
        }
        if(toAdd>0) p.next = new ListNode(toAdd);
        return newHead.next;
    }

    //如何优化
    public ListNode addTwoNumbers_x(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        int sum = 0;
        while(l1 != null || l2 != null){

            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum%10);
            p = p.next;
            sum /= 10;
        }
        if(sum%10 != 0)p.next = new ListNode(sum%10);
        return l3.next;


    }
}

package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class MergeTwoSortedLists_21 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,4};
        int[] nums2 = {1,3,4};
        ListNode l1 = ListNode.createNodeList(nums1);
        ListNode l2 = ListNode.createNodeList(nums2);
//        ListNode res = mergeTwoLists(l1, l2);
        ListNode res = mergeTwoLists_x(l1, l2);
        ListNode.printListNode(res);
    }

    //recursive
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l2==null) return l1;
        if(l1==null) return l2;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        if(l1.val<l2.val){
            pre.next = l1;
            pre = pre.next;
            pre.next = mergeTwoLists(l1.next, l2);
        }else{
            pre.next = l2;
            pre = pre.next;
            pre.next = mergeTwoLists(l1, l2.next);
        }
        return dummy.next;
    }

    //非递归
    public static ListNode mergeTwoLists_x(ListNode l1, ListNode l2) {
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        ListNode dummy = new ListNode(0);
        dummy.next = l1.val <= l2.val? l1:l2;
        ListNode p = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 == null) p.next = l2;
        else p.next = l1;

        return dummy.next;
    }



}

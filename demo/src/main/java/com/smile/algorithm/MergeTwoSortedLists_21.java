package com.smile.algorithm;

import com.smile.algorithm.ReverseLinkedListII_92.ListNode;

public class MergeTwoSortedLists_21 {

    public static void main(String[] args) {
        int[] nums1 = {5};
        int[] nums2 = {1,2,4};
        ListNode l1 = ReverseLinkedListII_92.createNode(nums1);
        ListNode l2 = ReverseLinkedListII_92.createNode(nums2);
        mergeTwoLists(l1, l2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

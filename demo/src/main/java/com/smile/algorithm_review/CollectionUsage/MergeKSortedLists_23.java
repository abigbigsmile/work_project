package com.smile.algorithm_review.CollectionUsage;

import com.smile.algorithm.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 5};
        int[] nums2 = {1, 3, 4};
        int[] nums3 = {2, 6};
        ListNode head1 = ListNode.createNodeList(nums1);
        ListNode head2 = ListNode.createNodeList(nums2);
        ListNode head3 = ListNode.createNodeList(nums3);
        ListNode[] lists = {head1, head2, head3};
        ListNode res = mergeKLists(lists);
        ListNode.printListNode(res);

    }

    // Memory Limit Exceeded
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head : lists){
            while(head!=null) {
                priorityQueue.offer(head);
                head = head.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }


    // 归并
    public static ListNode mergeKLists_x(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        return partition(lists, 0, lists.length-1);
    }

    public static ListNode partition(ListNode[] lists, int left, int right){
        if(left >= right) return lists[left];
        int mid = left + (right-left)/2;
        ListNode l1 = partition(lists, left, mid);
        ListNode l2 = partition(lists, mid+1, right);
        return mergeTwoList(l1, l2);
    }


    public static ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
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
        p.next = l1 == null? l2 :l1;
        return dummy.next;
    }



}

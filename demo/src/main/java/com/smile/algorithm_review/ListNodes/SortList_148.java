package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

public class SortList_148 {

    public static void main(String[] args) {
        int[] nums = {1,5,3,4,0};
        ListNode l1 = ListNode.createNodeList(nums);
        ListNode.printListNode(l1);
        ListNode res = sortList(l1);
        ListNode.printListNode(res);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head, middle = head, right = head;
        //寻找中间指针
        while(right != null && right.next != null){
            pre = middle;
            middle = middle.next;
            right = right.next.next;
        }
        pre.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(middle);
        return merge(node1, node2);

    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1!=null && l2!=null) {
            if(l1.val<=l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2=l2.next;
            }
            p = p.next;
        }
        p.next = (l1==null)? l2 : l1;
        return dummy.next;
    }

    /*
    public static ListNode merge(ListNode x, ListNode y){
        ListNode dummy = new ListNode(0), current = dummy;
        //如何while(x != null && y != null)到while(x != null || y != null)
        while(x != null || y != null){
            if(x == null){
                current.next = y;
                current = current.next;
                y = y.next;
            }else if(y == null){
                current.next = x;
                current = current.next;
                x = x.next;
            }else if(x.val <= y.val){
                current.next = x;
                current = current.next;
                x = x.next;
            }else{
                current.next = y;
                current = current.next;
                y = y.next;
            }
        }
        return dummy.next;
    }
     */

}

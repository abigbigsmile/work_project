package com.smile.algorithm;

import com.smile.algorithm.ReverseLinkedListII_92.ListNode;
/**
 * 使用归并排序算法排序链表
 */
public class SortList_148 {
    public static void main(String[] args) {
        int[] nums = {7,4, 6, 2,1,3};
        ListNode head = ReverseLinkedListII_92.createNode(nums);
        ListNode res = sortList(head);
        ReverseLinkedListII_92.printNode(res);
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

    public static ListNode merge(ListNode x, ListNode y){
        ListNode dummy = new ListNode(0), current = dummy;
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


}

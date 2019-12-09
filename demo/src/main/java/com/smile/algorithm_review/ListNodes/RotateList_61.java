package com.smile.algorithm_review.ListNodes;

import com.smile.algorithm.ListNode;

/**
 * 快慢指针
 */
public class RotateList_61 {

    public static void main(String[] args) {
        int[] nums = {0,1,2};
        ListNode head = ListNode.createNodeList(nums);
        ListNode.printListNode(head);
        ListNode res = rotateRight(head, 4);
        ListNode.printListNode(res);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        int count=1;
        ListNode p = head;
        //计算总数，顺便p指向尾结点
        while(p.next!=null){
            count++;
            p=p.next;
        }
        //查看倒数第几个为旋转后的头
        k = k%count;
        ListNode quick=head, slow=head;
        while(quick.next!=null){
            if(--k<0) slow=slow.next;
            quick=quick.next;
        }
        quick.next = head;
        head = slow.next;
        slow.next=null;
        return head;
    }


}

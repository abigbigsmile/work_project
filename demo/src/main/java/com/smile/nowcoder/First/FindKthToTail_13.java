package com.smile.nowcoder.First;

import com.smile.algorithm.ListNode;

public class FindKthToTail_13 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.createNodeList(nums);
        ListNode res = FindKthToTail(head, 1);
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        ListNode front=dummy, back=dummy;
        while(front!=null){
            front = front.next;
            if(k--<=0) back = back.next;
        }
        return back==dummy? null : back;
    }
}

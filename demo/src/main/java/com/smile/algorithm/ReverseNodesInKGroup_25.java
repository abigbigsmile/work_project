package com.smile.algorithm;

import com.smile.algorithm.ReverseLinkedListII_92.ListNode;

public class ReverseNodesInKGroup_25 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ReverseLinkedListII_92.createNode(nums);
        //ListNode res = reverseKGroup(head,3);
        //ListNode res = reverseKGroup_x(head,3);
        ListNode res = reverseKGroup_xx(head,3);
        ReverseLinkedListII_92.printNode(res);
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        boolean enough = true;
        while(enough){
            ListNode p = pre;
            for(int i=0; i<=k; i++){
                if(p == null){
                    enough = false;
                    break;
                }
                p = p.next;
            }
            if(enough){
                ListNode begin = pre.next, then = begin.next;
                for(int i=0; i<k-1; i++){
                    begin.next = then.next;
                    then.next = pre.next;
                    pre.next = then;
                    then = begin.next;
                }
                pre = begin;
            }

        }
        return dummy.next;

    }

    public static ListNode reverseKGroup_x(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

    public static ListNode reverseKGroup_xx(ListNode head, int k){
        if(head == null || head.next == null) return head;
        int count = 0;
        for(ListNode node=head; node!=null; count++, node=node.next);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=0; i+k<=count; i+=k){
            ListNode begin = pre.next, then = begin.next;
            for(int j=1; j<k; j++){
                begin.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = begin.next;
            }
            pre = begin;
        }
        return dummy.next;
    }
}

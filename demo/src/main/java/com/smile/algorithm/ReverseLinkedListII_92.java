package com.smile.algorithm;

public class ReverseLinkedListII_92 {

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,2,7,8};
        ListNode head = createNode(nums);
        partition(head, 3);
//        printNode(head);
//        reverseBetween(head, 2, 6);
//        printNode(head);

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        //对于1 - 2 -3 - 4 - 5，总共需要n-m步即可，第一步是将结点3放到结点1的后面，第二步将结点4放到结点1的后面。这是很有规律的操作
        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
            printNode(head);
        }
        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }


    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode createNode(int[] nums){
        ListNode head = new ListNode(0), p = head;
        for(int i=0; i<nums.length; i++){
            head.next = new ListNode(nums[i]);
            head = head.next;
        }
        return p.next;
    }

    public static void printNode(ListNode head){
        while(head!=null){
            if(head.next !=null)System.out.print(head.val + "->");
            else System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
        ListNode smaller = smallerHead, bigger = biggerHead;
        while (head != null) {
            if (head.val < x) {
                smaller = smaller.next = head;
            } else {
                bigger = bigger.next = head;
            }
            head = head.next;
        }
        // no need for extra check because of fake heads
        smaller.next = biggerHead.next; // join bigger after smaller
        bigger.next = null; // cut off anything after bigger
        return smallerHead.next;
    }
}

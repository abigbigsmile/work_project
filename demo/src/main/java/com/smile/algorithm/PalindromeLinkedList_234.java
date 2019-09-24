package com.smile.algorithm;

import com.smile.algorithm.ReverseLinkedListII_92.ListNode;

import java.util.HashMap;
import java.util.Map;

public class PalindromeLinkedList_234 {

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        ListNode head = ReverseLinkedListII_92.createNode(nums);
        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome_x(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; head != null; i++){
            map.put(i, head.val);
            head = head.next;
        }

        for(int i=1,j=map.size(); i<j; i++,j--){
            if(map.get(i).intValue() != map.get(j).intValue()) return false;
        }
        return true;
    }

    public static boolean isPalindrome_x(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) slow = slow.next;
        slow = reverse(slow);
        while(slow != null){
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;

    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}

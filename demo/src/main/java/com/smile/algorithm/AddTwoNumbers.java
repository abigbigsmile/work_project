package com.smile.algorithm;

import java.util.List;

public class AddTwoNumbers {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long one = 0, two = 0, three = 0;
        long x = 0, y = 0, z = 0;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            one = 10 * one + p1.val;
            p1 = p1.next;
        }
        while (one > 0) {
            x = 10 * x + one % 10;
            one /= 10;
        }
        while (p2 != null) {
            two = 10 * two + p2.val;
            p2 = p2.next;
        }
        while (two > 0) {
            y = 10 * y + two % 10;
            two /= 10;
        }
        three = x + y;
        System.out.println(three);
        ListNode l3 = new ListNode(0);
        ;
        ListNode p3 = l3;
        if (three == 0) return l3;
        while (three > 0) {
            long l = three % 10;
            p3.next = new ListNode((int) l);
            p3 = p3.next;
            three = three / 10;
        }
        return l3.next;

    }

    public static ListNode addTwoNumbers_x(ListNode l1, ListNode l2){
        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        int sum = 0;
        while(l1 != null || l2 != null){

            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum%10);
            p = p.next;
            sum /= 10;
        }
        if(sum%10 != 0)p.next = new ListNode(sum%10);
        return l3.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);//9
        ListNode l2 = new ListNode(1);//1999999999
        ListNode p = l2;
        for (int i = 0; i < 9; i++) {
            p.next = new ListNode(9);
            p = p.next;
        }

        addTwoNumbers_x(l1, l2);

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}



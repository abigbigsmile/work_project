package com.smile.algorithm;

import com.smile.algorithm.ReverseLinkedListII_92.ListNode;

import java.util.*;

public class MergeKSortedLists_23 {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        int[] l1 = {1, 4, 5};
        int[] l2 = {1, 3, 4};
        int[] l3 = {2, 6};
        listNodes[0] = ReverseLinkedListII_92.createNode(l1);
        listNodes[1] = ReverseLinkedListII_92.createNode(l2);
        listNodes[2] = ReverseLinkedListII_92.createNode(l3);
        //mergeKLists(listNodes);
        //mergeKLists_x(listNodes);
        ListNode p = mergeKLists_xx(listNodes);
        System.out.println();

    }


    private static ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, Integer> frepMap = new HashMap<>();
        for(ListNode p : lists){
            while(p != null){
                frepMap.put(p.val, frepMap.getOrDefault(p.val, 0)+1);
                p = p.next;
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getKey(), b.getKey()));
        for(Map.Entry<Integer, Integer> entry : frepMap.entrySet()) pq.offer(entry);

        ListNode dummy = new ListNode(0);
        ListNode pos = dummy;

        while(!pq.isEmpty()){
            Map.Entry<Integer, Integer> entry = pq.poll();
            int val = entry.getKey();
            for(int i=0; i<entry.getValue(); i++) {
                pos.next = new ListNode(val);
                pos = pos.next;
            }
        }
        return dummy.next;
    }

    private static ListNode mergeKLists_x(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val<o2.val) return -1;
                else if (o1.val==o2.val) return 0;
                else return 1;
            }
        });

        for(ListNode node : lists){
            if(node != null) pq.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode pos = dummy;

        while(!pq.isEmpty()){
            pos.next = pq.poll();
            pos = pos.next;
            if(pos.next != null) pq.offer(pos.next);
        }
        return dummy.next;
    }

    private static ListNode mergeKLists_xx(ListNode[] lists){
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        return sort(lists, 0, lists.length-1);
    }

    private static ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return mergeTwoList(l1, l2);
    }

    private static ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1 != null || l2 != null){
            if(l2 == null || l1 != null && l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        return dummy.next;
    }


}

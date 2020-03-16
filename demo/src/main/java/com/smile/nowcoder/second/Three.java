package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/16 22:52
 * @ModifiedBy smile
 */

import com.smile.algorithm.ListNode;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 */
public class Three {

    /**
     * 每次从尾巴插入
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList();
        while(listNode!=null){
            res.add(0, listNode.val);
            listNode = listNode.next;
        }
        return res;
    }


    /**
     * 翻转链表
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_x(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList();
        ListNode newHead = null;
        while(listNode!=null){
            ListNode temp = listNode.next;
            listNode.next = newHead;
            newHead = listNode;
            listNode = temp;
        }
        while(newHead!=null){
            res.add(newHead.val);
            newHead = newHead.next;
        }
        return res;
    }

    /**
     * 3. 使用stack
     */

    /**
     * 递归
     */
    public ArrayList<Integer> printListFromTailToHead_xx(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList();
        if(listNode==null) return res;
        else{
            res = printListFromTailToHead(listNode.next);
            res.add(listNode.val);
        }
        return res;
    }





}

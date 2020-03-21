package com.smile.nowcoder.second;

import com.smile.algorithm.ListNode;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/20 19:31
 * @ModifiedBy smile
 */

/**
 * 题目描述: 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class FifthtySeven {

    /**
     * 快慢指针：应该画图研究
     * https://www.nowcoder.com/profile/163334/codeBookDetail?submissionId=1512740
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead==null || pHead.next==null) return null;
        ListNode fast = pHead, low = pHead;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            low = low.next;
            if(fast==low) break;
        }

        if(fast==null || fast.next==null) return null;

        low = pHead;
        while(fast!=low){
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }

}

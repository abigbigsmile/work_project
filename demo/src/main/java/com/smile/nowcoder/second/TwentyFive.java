package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/18 12:15
 * @ModifiedBy smile
 */

/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class TwentyFive {


    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return null;
        // 分为三步
        // 第一步：复制链表
        RandomListNode first = pHead;
        while(first!=null){
            RandomListNode copyNode = new RandomListNode(first.label);
            copyNode.next = first.next;
            first.next = copyNode;
            first = copyNode.next;
        }

        //第二步：复制结点的特殊指针
        RandomListNode second = pHead;
        while(second!=null){
            RandomListNode copyNode = second.next;
            copyNode.random = second.random==null? null:second.random.next;
            second = copyNode.next;
        }

        //第三步：拆分
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        RandomListNode pre = pHead;
        while(pre!=null && pre.next!=null){
            RandomListNode temp = pre.next.next;
            cur.next = pre.next;
            pre.next = temp;
            pre = temp;
            cur = cur.next;
        }

        return dummy.next;
    }

}

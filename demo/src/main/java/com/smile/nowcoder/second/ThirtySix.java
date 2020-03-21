package com.smile.nowcoder.second;

import com.smile.algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 14:52
 * @ModifiedBy smile
 */
public class ThirtySix {

    /*
        假定 List1长度: a+n  List2 长度:b+n, 且 a<b
        那么 p1 会先到链表尾部, 这时p2 走到 a+n位置,将p1换成List2头部
        接着p2 再走b+n-(n+a) =b-a 步到链表尾部,这时p1也走到List2的b-a位置，还差a步就到可能的第一个公共节点。
        将p2 换成 List1头部，p2走a步也到可能的第一个公共节点。如果恰好p1==p2,那么p1就是第一个公共节点。  或者p1和p2一起走n步到达列表尾部，二者没有公共节点，退出循环。 同理a>=b.
        时间复杂度O(n+a+b)

       */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null) return null;
        ListNode a = pHead1;
        ListNode b = pHead2;
        while(a != b){
            a = a==null? pHead2:a.next;
            b = b==null? pHead1:b.next;
        }
        return a;
    }

    // 使用hashset,但是题目要求空间复杂度为O(1)
    public class Solution_x {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null || headB==null) return null;
            Set<ListNode> set = new HashSet<>();
            ListNode temp = headA;
            while(temp!=null) {
                set.add(temp);
                temp = temp.next;
            }
            temp = headB;
            while(temp!=null){
                if(set.contains(temp)) return temp;
                temp = temp.next;
            }
            return null;
        }
    }


    /*
    1, Get the length of the two lists.

    2, Align them to the same start point.

    3, Move them together until finding the intersection point, or the end null
*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

}

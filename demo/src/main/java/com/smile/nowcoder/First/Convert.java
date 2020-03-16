package com.smile.nowcoder.First;

import com.smile.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Convert {

    public static void main(String[] args) {
        Integer[] nums = {10,6,14,4,8,12,16};
        TreeNode root = TreeNode.createBinaryTree(nums, 0);
//        TreeNode res = Convert(root);
        TreeNode res = Convert_x(root);
        System.out.println();
    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                cur.left = pre;
                if(pre!=null) pre.right = cur;
                pre = cur;
                cur = cur.right;
            }
        }

        while(pRootOfTree.left!=null) pRootOfTree = pRootOfTree.left;
        return pRootOfTree;
    }

    /*
        解题思路：
            1.将左子树构造成双链表，并返回链表头节点。
            2.定位至左子树双链表最后一个节点。
            3.如果左子树链表不为空的话，将当前root追加到左子树链表。
            4.将右子树构造成双链表，并返回链表头节点。
            5.如果右子树链表不为空的话，将该链表追加到root节点之后。
            6.根据左子树链表是否为空确定返回的节点。
    */
    // 重要：这个方法是将pRootOfTree为根结点的树转换为双向链表，并且返回最左结点
    public static TreeNode Convert_x(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        // 1.将左子树构造成双链表，并返回链表头节点。
        TreeNode left = Convert(pRootOfTree.left);
        // 2.定位至左子树双链表最后一个节点。
        if(left!=null){
            TreeNode p = left;
            while(p.right!=null) p = p.right;
            // 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
            pRootOfTree.left = p;
            p.right = pRootOfTree;
        }
        // 4.将右子树构造成双链表，并返回链表头节点。
        TreeNode right = Convert(pRootOfTree.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
        if(right!=null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        // 6.根据左子树链表是否为空确定返回的节点。
        return left==null? pRootOfTree : left;

    }
}

package com.smile.nowcoder.second;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/19 15:39
 * @ModifiedBy smile
 */


import com.smile.algorithm.TreeNode;

/**
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class ThirtyNine {

    //递归
    public boolean IsBalanced_Solution(TreeNode root) {
        return root==null? true : Math.abs(getDepth(root.left)-getDepth(root.right))<=1;
    }
    public int getDepth(TreeNode node){
        return node==null? 0 : Math.max(getDepth(node.left), getDepth(node.right))+1;
    }


    //剪枝
    public boolean IsBalanced_Solution_x(TreeNode root) {
        return getDepth(root)==-1? false : true;
    }

    public int getDepth_x(TreeNode node){
        if(node==null) return 0;
        int left = getDepth(node.left);
        if(left==-1) return -1;
        int right = getDepth(node.right);
        if(right==-1) return -1;
        return Math.abs(left-right)>1? -1 : 1+Math.max(left, right);
    }

}

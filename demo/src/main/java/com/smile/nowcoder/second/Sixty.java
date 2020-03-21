package com.smile.nowcoder.second;

import com.smile.algorithm.TreeNode;

import java.util.LinkedList;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/21 0:47
 * @ModifiedBy smile
 */

/**
 * 题目描述: 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Sixty {

    //满屏递归
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null) return true;
        return compare(pRoot.left, pRoot.right);
    }
    boolean compare(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null || left.val!=right.val) return false;
        return compare(left.left, right.right) && compare(left.right, right.left);
    }


    //BFS
    boolean isSymmetrical_x(TreeNode pRoot){
        if(pRoot==null) return true;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left==null && right==null) continue;
            if(left==null || right==null || left.val!=right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    //DFS
    boolean isSymmetrical_xx(TreeNode pRoot){
        if(pRoot == null) return true;
        LinkedList<TreeNode> s = new LinkedList<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while(!s.isEmpty()) {
            TreeNode right = s.pop();//成对取出
            TreeNode left = s.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }

}

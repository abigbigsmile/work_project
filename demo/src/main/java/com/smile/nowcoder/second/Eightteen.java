package com.smile.nowcoder.second;

import com.smile.algorithm.TreeNode;

import java.util.LinkedList;

/**
 * @Author: smile
 * @Description
 * @Date Create in 2020/3/17 23:47
 * @ModifiedBy smile
 */
public class Eightteen {

    // 递归
    public class Solution {
        public void Mirror(TreeNode root) {
            if(root==null) return;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    //遍历
    public void Mirror(TreeNode root) {
        if(root == null) return;
        LinkedList<TreeNode> stack = new LinkedList();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if(cur.left!=null) stack.push(cur.left);
            if(cur.right!=null) stack.push(cur.right);
        }
    }
}

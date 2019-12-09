package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import com.smile.algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6};
        TreeNode root = TreeNode.createBinaryTree(nums, 0);
        List<Integer> list = preorderTraversal_x(root);
        System.out.println(list);
    }

    // recursive:递归前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    public static void helper(List<Integer> res, TreeNode root){
        if(root==null) return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    public static List<Integer> preorderTraversal_x(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
        return res;
    }

    // 有点难以理解
    public static List<Integer> preorderTraversal_xx(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                res.add(cur.val);
                stack.push(cur.right);
                cur = cur.left;
            }else{
                cur = stack.pop();
            }
        }
        return res;
    }




}

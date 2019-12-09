package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import com.smile.algorithm.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal_145 {

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6};
        TreeNode root = TreeNode.createBinaryTree(nums, 0);
        List<Integer> list1 = postorderTraversal(root);
        List<Integer> list2 = postorderTraversal_x(root);
        List<Integer> list3 = postorderTraversal_xx(root);
//        List<Integer> list4 = inorderTraversal_xxx(root);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
//        System.out.println(list4);
    }


    //递归
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }

    public static List<Integer> postorderTraversal_x(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root==null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if(cur.left!=null) stack.push(cur.left);
            if(cur.right!=null) stack.push(cur.right);
        }
        return res;
    }


    public static List<Integer> postorderTraversal_xx(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                res.addFirst(cur.val);
                cur = cur.right;
            }else{
                cur = stack.pop();
                cur = cur.left;
            }
        }
        return res;
    }




}

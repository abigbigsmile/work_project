package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import com.smile.algorithm.TreeNode;

import java.util.*;

public class BinaryTreeInorderTraversal_94 {

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6};
        TreeNode root = TreeNode.createBinaryTree(nums, 0);
        List<Integer> list1 = inorderTraversal(root);
        List<Integer> list2 = inorderTraversal_x(root);
        List<Integer> list3 = inorderTraversal_xx(root);
        List<Integer> list4 = inorderTraversal_xxx(root);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
    }

    //递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    //带helper的递归
    public static List<Integer> inorderTraversal_x(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public static void helper(TreeNode root, List<Integer> res){
        if(root==null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    // 非递归
    public static List<Integer> inorderTraversal_xx(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }


    public static List<Integer> inorderTraversal_xxx(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

}

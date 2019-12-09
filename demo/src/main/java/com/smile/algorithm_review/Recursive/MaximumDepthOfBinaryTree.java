package com.smile.algorithm_review.Recursive;

import com.smile.algorithm.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7,8};
        TreeNode root = TreeNode.createBinaryTree(nums, 0);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

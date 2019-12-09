package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import com.smile.algorithm.TreeNode;

public class PathSum_112 {

    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,55,13,4,7,2,9,1};
        TreeNode root = TreeNode.createBinaryTree(nums, 0);
        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null || sum<0) return false;
        if(root.left==null && root.right==null && sum-root.val==0) return true;
        boolean leftTree=false, rightTree=false;
        if(root.left!=null) leftTree =hasPathSum(root.left, sum-root.val);
        if(root.right!=null) rightTree =hasPathSum(root.right, sum-root.val);
        return leftTree || rightTree;
    }

}

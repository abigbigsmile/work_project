package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import com.smile.algorithm.TreeNode;

public class MinimumDepthOfBinaryTree_111 {

    public static void main(String[] args) {

    }


    public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null) return minDepth(root.right)+1;
        if(root.right==null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


}

package com.smile.algorithm;

import com.smile.algorithm.BinaryTreePreorderTraversal_144.TreeNode;

public class InvertBinaryTree {

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3","4", "5","6", "7", "8","9"};
        TreeNode root = BinaryTreePreorderTraversal_144.buildTree(arr, 0);
        invertTreee(root);
        System.out.println();
    }

    private static void invertTreee(TreeNode root){
        if(root == null) return;
        invertTreee(root.left);
        invertTreee(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}

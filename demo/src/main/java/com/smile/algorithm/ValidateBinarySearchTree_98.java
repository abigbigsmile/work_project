package com.smile.algorithm;

import com.smile.algorithm.BinaryTreePreorderTraversal_144.TreeNode;

public class ValidateBinarySearchTree_98 {

    public static void main(String[] args) {
        String[] arr = {"0", "-1"};
        TreeNode root = BinaryTreePreorderTraversal_144.buildTree(arr, 0);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left==root.right) return true;
        if(root.left == null) {
            if(root.val < root.right.val) return isValidBST(root.right);
        }
        else if(root.right == null){
            if(root.val>root.left.val) return isValidBST(root.left);
        }
        else {
            if(root.val>root.left.val && root.val<root.right.val)return isValidBST(root.left) && isValidBST(root.right);
        }
        return false;
    }
}

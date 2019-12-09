package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import com.smile.algorithm.TreeNode;

public class CountCompleteTreeNodes_222 {

    public static void main(String[] args) {

    }


    public static int countNodes(TreeNode root) {
        if(root==null) return 0;
        int leftHeight = getHeigth(root.left);
        int rightHeight = getHeigth(root.right);
        if(leftHeight==rightHeight) return (1<<leftHeight)-1;
        else return countNodes(root.left)+countNodes(root.right)+1;
    }

    public static int getHeigth(TreeNode node){
        if(node==null) return 0;
        return getHeigth(node.left)+1;
    }
}

package com.smile.algorithm;

import com.smile.algorithm.BinaryTreePreorderTraversal_144.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MaximumDepthOfBinaryTree_104 {
    public static void main(String[] args) {

        String[] arr = {"1", "2", "3","4", "5","6", "7", "8","9"};
        TreeNode root = BinaryTreePreorderTraversal_144.buildTree(arr, 0);
        System.out.println(maxDepth(root));
        System.out.println(maxDepth_dfs(root));
        System.out.println(maxDepth_bfs(root));
    }

    //二叉树深度——递归算法
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    //二叉树深度——DFS算法
    public static int maxDepth_dfs(TreeNode root){
        if(root == null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();
        nodeStack.push(root);
        heightStack.push(1);
        int max = 1;
        while(!nodeStack.isEmpty()){
            TreeNode currentNode = nodeStack.pop();
            int currentHeigth = heightStack.pop();
            max = Math.max(max, currentHeigth);
//            System.out.println(currentNode.val);
            if(currentNode.right != null){
                nodeStack.push(currentNode.right);
                heightStack.push(currentHeigth+1);
            }
            if(currentNode.left != null){
                nodeStack.push(currentNode.left);
                heightStack.push(currentHeigth+1);
            }
        }
        return max;
    }
    //二叉树深度——BFS
    public static int maxDepth_bfs(TreeNode root){
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while(!queue.isEmpty()){
            int num = queue.size();
            for(int i=0; i<num; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
            }
            height ++;
        }
        return height;
    }

}

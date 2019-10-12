package com.smile.algorithm;

import com.smile.algorithm.BinaryTreePreorderTraversal_144.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinimumDepthOfBinaryTree_111 {

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3","4", "5","6", "7", "8","9"};
        TreeNode root = BinaryTreePreorderTraversal_144.buildTree(arr, 0);
        System.out.println(minDepth(root));
        System.out.println(minDepth_bfs(root));
        System.out.println(minDepth_dfs(root));
    }

    //最小深度——递归
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static int minDepth_dfs(TreeNode root){
        if(root == null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();
        PriorityQueue<Integer> heightQueue = new PriorityQueue<>();
        nodeStack.push(root);
        heightStack.push(1);
        while(!nodeStack.isEmpty()){
            TreeNode currentNode = nodeStack.pop();
            int height = heightStack.pop();
            if(currentNode.left == null && currentNode.right == null) heightQueue.offer(height);
            if(currentNode.right != null){
                nodeStack.push(currentNode.right);
                heightStack.push(height+1);
            }
            if(currentNode.left != null) {
                nodeStack.push(currentNode.left);
                heightStack.push(height+1);
            }
        }
        return heightQueue.peek();
    }

    //最小深度——bfs算法
    public static int minDepth_bfs(TreeNode root){
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int height = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            int num = queue.size();
            while (num -- > 0){
                TreeNode currentNode = queue.poll();
                if(currentNode.left == null && currentNode.right == null) return height;
                if(currentNode.left != null) queue.offer(currentNode.left);
                if(currentNode.right != null) queue.offer(currentNode.right);
            }
            height ++;
        }
        return height;
    }
}
